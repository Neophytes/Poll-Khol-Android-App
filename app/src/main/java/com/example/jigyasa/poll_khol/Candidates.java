package com.example.jigyasa.poll_khol;

import com.orm.SugarRecord;

/**
 * Created by dell pc on 21-08-2015.
 */
public class Candidates extends SugarRecord<Candidates> {
    String name;

    public Candidates(){

    }

    public Candidates(String name){
        this.name=name;
    }


}
