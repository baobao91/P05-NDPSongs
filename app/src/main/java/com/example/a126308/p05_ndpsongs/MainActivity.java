package com.example.a126308.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    Button btnInsert, btnShow;
    RadioGroup rgStars;
    ArrayList<String> al;
    ArrayAdapter aa;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText)findViewById(R.id.editTextTitle);
        etSinger = (EditText)findViewById(R.id.editTextSinger);
        etYear = (EditText)findViewById(R.id.editTextYear);

        btnInsert = (Button) findViewById(R.id.buttonInsert);
        btnShow = (Button) findViewById(R.id.buttonShow);

        rgStars = (RadioGroup)findViewById(R.id.radioGroupStars);
        db = new DBHelper(MainActivity.this);

        al = new ArrayList<String>();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleData = etTitle.getText().toString();
                String singerData = etSinger.getText().toString();
                String year = etYear.getText().toString();
                Integer intYear = Integer.parseInt(year);

                int selectedButtonId = rgStars.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                int selectedRB = Integer.parseInt(rb.getText().toString());


                db.insertSongTitle(titleData,singerData,intYear,selectedRB);
                Toast.makeText(MainActivity.this,"Insert Successful", Toast.LENGTH_LONG).show();
                db.close();


            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(i);
            }
        });
    }

//    protected void onActivityResult(int requestCode, int resultCode,
//                                    Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_OK && requestCode == 9){
//            btnShow.performClick();
//        }
//    }


}
