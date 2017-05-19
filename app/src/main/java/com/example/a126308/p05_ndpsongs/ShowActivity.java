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

public class ShowActivity extends AppCompatActivity {

    ListView lv;
    Button btn;
    ArrayList<String> al;//mala
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        lv=(ListView)findViewById(R.id.lvSong);
        btn=(Button)findViewById(R.id.button);
        al = new ArrayList<String>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aa.notifyDataSetChanged();
            }
        });

        lv = (ListView) findViewById(R.id.lvSong);
        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Intent i = new Intent();
                String data = al.get(position);
                String id = data.split(",")[0].split(":")[1];
                String content = data.split(",")[1].trim();

                Song target = new Song(Integer.parseInt(id), content);
                i.putExtra("data", target);
                startActivityForResult(i, 9);


            }
        });
    }


}



