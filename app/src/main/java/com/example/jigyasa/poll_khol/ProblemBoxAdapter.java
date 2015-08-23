package com.example.jigyasa.poll_khol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell pc on 22-08-2015.
 */
public class ProblemBoxAdapter extends ArrayAdapter<ProblemBox> {

    Context context;
    ArrayList<ProblemBox> arr;
    LayoutInflater l;

    public ProblemBoxAdapter(Context context, ArrayList<ProblemBox> arr,LayoutInflater l) {
        super(context, R.layout.problemboxview);
        this.context=context;
        this.arr=arr;
        this.l=l;
    }

    public int getCount() {
        return arr.size();
    }

    public int getItemViewCount()
    {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        v = l.inflate(R.layout.problemboxview,null);
        ProblemBox problemBox=arr.get(position);
        TextView tv1=(TextView)v.findViewById(R.id.problem_title);
        tv1.setText(problemBox.problem);
        TextView tv2=(TextView)v.findViewById(R.id.upvotes);
        tv2.setText(""+problemBox.upvote);
        return v;
    }
}


