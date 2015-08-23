package com.example.jigyasa.poll_khol;

import com.orm.SugarRecord;

/**
 * Created by dell pc on 21-08-2015.
 */
public class Manifesto extends SugarRecord<Manifesto> {
    String title;
    String description;
    int up;
    int down;
    int progress;
    // Float average_likes;

    public Manifesto(){

    }

    public Manifesto(String title, String description){
        this.title=title;
        this.description=description;

    }

    public void setProgressBar(int progress){
        this.progress=progress;
    }
}