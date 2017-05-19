package com.example.a126308.p05_ndpsongs;

import java.io.Serializable;

/**
 * Created by 126308 on 19/5/2017.
 */

public class Song implements Serializable {

    private int id, years, stars;
    private String title, singers;

    public Song(int id, String title) {
        this.id = id;
        this.years = years;
        this.stars = stars;
        this.title = title;
        this.singers = singers;
    }

    public int getId() {
        return id;
    }

    public int getYears() {
        return years;
    }

    public int getStars() {
        return stars;
    }

    public String getTitle(){
        return title;
    }

    public String getSingers() {
        return singers;
    }
}
