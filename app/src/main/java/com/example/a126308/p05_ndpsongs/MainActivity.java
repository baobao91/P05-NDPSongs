package com.example.a126308.p05_ndpsongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText)findViewById(R.id.editTextTitle);
        etSinger = (EditText)findViewById(R.id.editTextSinger);
        etYear = (EditText)findViewById(R.id.editTextYear);

        btnInsert = (Button) findViewById(R.id.buttonInsert);
        btnShow = (Button) findViewById(R.id.buttonShow);

        rgStars = (RadioGroup)findViewById(R.id.rgStars);

        al = new ArrayList<String>();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleData = etTitle.getText().toString();
                String singerData = etSinger.getText().toString();
                String year = etYear.getText().toString();

                int yearData = Integer.parseInt(year);


                DBHelper dbh = new DBHelper(MainActivity.this);
                long row_affected = dbh.insertSongTitle(titleData, singerData, yearData);
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

            }
        });
    }
}
