package com.example.a126308.p05_ndpsongs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.data;

public class ShowActivity extends AppCompatActivity {

    ListView lv;
    Button btn;
    ArrayList<Song> song;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        btn = (Button)findViewById(R.id.button);

        lv = (ListView) findViewById(R.id.lvSong);
        DBHelper db = new DBHelper(ShowActivity.this);
        song = db.getAllSong();

        aa = new songArrayAdapter(this, R.layout.row, song);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();
        db.close();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Intent i = new Intent(ShowActivity.this, ModifySong.class);
                Song data = song.get(position);
//                String id = data.split(",")[0].split(":")[1];
//                String content = data.split(",")[1].trim();

//                Song target = new Song(Integer.parseInt(id), content);
                i.putExtra("data", data);
                startActivityForResult(i, 9);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9 ) {
            DBHelper db = new DBHelper(ShowActivity.this);
            song = db.getAllSong();
            aa = new songArrayAdapter(ShowActivity.this, R.layout.row, song);
            lv.setAdapter(aa);
        }
    }






}



