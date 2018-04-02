package suvamjain.example.com.govhack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import suvamjain.example.com.govhack.adapter.HintAdapter;

import static suvamjain.example.com.govhack.R.layout.spinner_item;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private AppCompatActivity activity = MainActivity.this;
    Spinner soil,course;
    private EditText temp,rainfall;
    private HintAdapter soilsType,course_Type;
    private int soil_pos,course_pos;
    private String Soil_Value,Course_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soil = (Spinner) findViewById(R.id.soil);
        course = (Spinner) findViewById(R.id.course);
        temp = (EditText) findViewById(R.id.temp);
        rainfall = (EditText) findViewById(R.id.rain);

        soil.setOnItemSelectedListener(this);
        course.setOnItemSelectedListener(this);

        final List<String> Soils = new ArrayList<String>();
        Soils.add("Red Soil");
        Soils.add("Loamy Soil");
        Soils.add("Black Soil");
        Soils.add("Wet Soil");
        Soils.add("Select Soil Type");

        soilsType = new HintAdapter(this, spinner_item, Soils);
        soilsType.setDropDownViewResource(spinner_item);


        soil.setAdapter(soilsType);
        // show hint
        soil.setSelection(soilsType.getCount());

        // for courses -
        final List<String> Courses = new ArrayList<String>();
        Courses.add("Agricultural Engineering");
        Courses.add("Power Resources");
        Courses.add("Farming Techniques");
        Courses.add("Select Courses");

        course_Type = new HintAdapter(this, spinner_item, Courses);
        course_Type.setDropDownViewResource(spinner_item);


        course.setAdapter(course_Type);
        // show hint
        course.setSelection(course_Type.getCount());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.soil:
                soil_pos = position;
                Soil_Value = soilsType.getItem(soil_pos).toString();
                Toast.makeText(MainActivity.this,"Your have selected " + Soil_Value,Toast.LENGTH_SHORT).show();
                break;
            case R.id.course:
                course_pos = position;
                Course_value = course_Type.getItem(course_pos).toString();
                Toast.makeText(MainActivity.this,"Your have selected " + Course_value,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
