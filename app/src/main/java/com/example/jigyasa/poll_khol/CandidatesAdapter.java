package com.example.jigyasa.poll_khol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell pc on 22-08-2015.
 */
public class CandidatesAdapter extends ArrayAdapter<Candidates> {

    Context context;
    ArrayList<Candidates> arr;
    int id;
    //LayoutInflater l;

    public CandidatesAdapter(Context context,  ArrayList<Candidates> arr, int id) {
        super(context, R.layout.candidateview);
        this.context=context;
        this.arr=arr;
        this.id=id;
       // this.l=l;
    }

    public int getCount() {
        return arr.size();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.candidateview,null);
        TextView tv=(TextView)v.findViewById(R.id.textView1);
        ImageView im = (ImageView)v.findViewById(R.id.party_image);
        if(id==0)
        im.setImageDrawable(context.getResources().getDrawable(R.drawable.aap));
        else if(id==1)
            im.setImageDrawable(context.getResources().getDrawable(R.drawable.bjp));
        else
            im.setImageDrawable(context.getResources().getDrawable(R.drawable.congress));
        Candidates n=arr.get(position);
        tv.setText(n.name);
        return v;
    }
}
