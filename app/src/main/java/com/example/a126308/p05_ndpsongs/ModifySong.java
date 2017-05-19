package com.example.a126308.p05_ndpsongs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by 15056215 on 19/5/2017.
 */

public class ModifySong extends AppCompatActivity {

    TextView tvId;
    EditText etTitle3, etSinger3, etYear3;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rg;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        tvId = (TextView)findViewById(R.id.tvSongId);
        etTitle3 = (EditText) findViewById(R.id.etSongTitle3);
        etSinger3 = (EditText) findViewById(R.id.editTextSingers3);
        etYear3 = (EditText) findViewById(R.id.editTextYears3);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        rg = (RadioGroup)findViewById(R.id.rgStars3);


    }

}
