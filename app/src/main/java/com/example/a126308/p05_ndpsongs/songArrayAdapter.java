package com.example.a126308.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15056215 on 21/5/2017.
 */

public class songArrayAdapter extends ArrayAdapter<Song> {

    Context context;
    ArrayList<Song> songs;
    int resource;
    ImageView iv1, iv2, iv3, iv4, iv5;

    public songArrayAdapter(Context context, int resource, ArrayList<Song> songs) {
        super(context, resource, songs);
        this.context = context;
        this.songs = songs;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);
        TextView tvyear = (TextView) rowView.findViewById(R.id.textViewYear);
        TextView tvTitle = (TextView) rowView.findViewById(R.id.textViewTitle);
        TextView tvSingers = (TextView) rowView.findViewById(R.id.textViewSingers);

        iv1 = (ImageView) rowView.findViewById(R.id.imageView1);
        iv2 = (ImageView) rowView.findViewById(R.id.imageView2);
        iv3 = (ImageView) rowView.findViewById(R.id.imageView3);
        iv4 = (ImageView) rowView.findViewById(R.id.imageView4);
        iv5 = (ImageView) rowView.findViewById(R.id.imageView5);


        Song song = songs.get(position);
        String title = song.getTitle();
        String singer = song.getSingers();
        int year = song.getYear();

        tvyear.setText("" + year);
        tvTitle.setText(title);
        tvSingers.setText(singer);
        int star = song.getStars();

        if (star == 5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (star ==4) {
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (star == 3) {
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);

        } else if (star == 2) {
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);

        } else {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }


        return rowView;
    }


}



