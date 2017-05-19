package com.example.a126308.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

        al = new ArrayList<String>();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleData = etTitle.getText().toString();
                String singerData = etSinger.getText().toString();
                String year = etYear.getText().toString();

                int yearData = Integer.parseInt(year);

                int stars = getStars();
                
                DBHelper dbh = new DBHelper(MainActivity.this);
                long row_affected = dbh.insertSongTitle(titleData, singerData, yearData, stars);
                dbh.close();

                if (row_affected != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbh = new DBHelper(MainActivity.this);

                al.clear();
                al.addAll(dbh.getAllSongTitle());
                dbh.close();

                String txt = "";
                for (int i = 0; i< al.size(); i++){
                    String tmp = al.get(i);
                    txt += tmp + "\n";
                }

                Intent i = new Intent(MainActivity.this, ShowActivity.class);
                startActivityForResult(i, 9);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
            btnShow.performClick();
        }
    }
    private int getStars() {
        int stars = 1;
        switch (rgStars.getCheckedRadioButtonId()) {
            case R.id.radioButton1:
                stars = 1;
                break;
            case R.id.radioButton2:
                stars = 2;
                break;
            case R.id.radioButton3:
                stars = 3;
                break;
            case R.id.radioButton4:
                stars = 4;
                break;
            case R.id.radioButton5:
                stars = 5;
                break;
        }
        return stars;
    }
}
