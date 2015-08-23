package com.example.jigyasa.poll_khol;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProblemBoxFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    List<ProblemBox> problemBoxList;
    ArrayList<ProblemBox> data;
    View v;
    LayoutInflater inflater;
    ListView lv;
    ProblemBoxAdapter adapter;
    public ProblemBoxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.inflater=inflater;
        v= inflater.inflate(R.layout.fragment_problem_box, container, false);
       // ArrayList data=new ArrayList();
     /*   Bundle args = getArguments();
        int index = args.getInt("index");*/
        int index = 2;
        data=new ArrayList<>();
       problemBoxList =ProblemBox.listAll(ProblemBox.class);
        long number=ProblemBox.count(ProblemBox.class,null,null);
//        if(index==0){
//            for(int i=0;i<1;i++)
//                data.add(problemBoxList.get(i));
//        }
//        else if(index==1){
//            for(int i=0;i<2;i++)
//                data.add(problemBoxList.get(i));
//        }
//        else{
//            for(int i=0;i<3;i++)
//                data.add(problemBoxList.get(i));
//        }
        for(int i=0;i<number;i++){
            data.add(problemBoxList.get(i));
        }
        adapter=new ProblemBoxAdapter(getActivity(),data,inflater);
        lv=(ListView)v.findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        Button b=(Button)v.findViewById(R.id.issuebutton);
        b.setOnClickListener(this);
        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ProblemBox problemBox= problemBoxList.get(i);
        Intent intent =new Intent();
        intent.setClass(getActivity(), DetailedProblemsActivity.class);
        intent.putExtra("Title",problemBox.problem);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
       Intent i=new Intent();
        i.setClass(getActivity(),AddIssue.class);
        startActivityForResult(i,1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data1){
        Bundle b=data1.getExtras();
        String title=b.getString("title");
        String desc=b.getString("description");
//        problemBoxList =ProblemBox.listAll(ProblemBox.class);
//        long number=ProblemBox.count(ProblemBox.class,null,null);
//        data=new ArrayList<>();
//        for(int i=0;i<number;i++){
//            data.add(problemBoxList.get(i));
//        }
        ProblemBox newproblem=new ProblemBox(title,desc);
        data.add(newproblem);
       adapter.notifyDataSetChanged();
    }
}
