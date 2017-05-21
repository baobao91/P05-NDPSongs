package com.example.a126308.p05_ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

    Intent i ;

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

        i = getIntent();

        data = (Song) i.getSerializableExtra("data");

        //Get text from ShowActivity
        tvId.setText("" + data.get_id());
        etTitle3.setText(data.getTitle());
        etSinger3.setText(data.getSingers());
        etYear3.setText("" + data.getYear());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySong.this);
                int selected = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selected);
                int selectedRB = Integer.parseInt(rb.getText().toString());
                data.setTitle(etTitle3.getText().toString());
                data.setSingers(etSinger3.getText().toString());
                data.setYear(Integer.parseInt(etYear3.getText().toString()));
                data.setStars(selectedRB);
                dbh.updateSong(data);
                dbh.close();
                setResult(RESULT_OK);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifySong.this);
                dbh.deleteNote(data.get_id());
                dbh.close();
                setResult(RESULT_OK);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }






}
