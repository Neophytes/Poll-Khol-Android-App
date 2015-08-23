package com.example.jigyasa.poll_khol;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by dell pc on 21-08-2015.
 */
public class ProblemBox extends SugarRecord<ProblemBox>{
    String problem;
    String description;
    int upvote;
   ArrayList<String> comments;

    public ProblemBox(){

    }

    public ProblemBox(String problem, String description){
        this.problem=problem;
        this.description=description;
    }

    public void add_comment(String comment){
        comments.add(comment);
    }
}
