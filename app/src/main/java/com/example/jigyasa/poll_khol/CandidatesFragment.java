package com.example.jigyasa.poll_khol;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CandidatesFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_candidates, container, false);
        Bundle args = getArguments();
        int index = args.getInt("index");
        ArrayList<Candidates> arr=new ArrayList<Candidates>();
        List<Candidates> allcandidates=Candidates.listAll(Candidates.class);
      //  Candidates candidates = new Candidates("oooo");
        if(index==0){
            for(int i=0;i<4;i++)
                arr.add(allcandidates.get(i));
        }
        else if(index==1){
            for(int i=4;i<8;i++)
                arr.add(allcandidates.get(i));
        }
        else{
            for(int i=8;i<12;i++)
                arr.add(allcandidates.get(i));
        }
       //for(int i=0;i<12;i++){
         //   arr.add(allcandidates.get(i));
        //    arr.add(candidates);
       // }
        CandidatesAdapter candidatesAdapter=new CandidatesAdapter(getActivity(),arr,index);
        ListView lv=(ListView)v.findViewById(R.id.listView);
        lv.setAdapter(candidatesAdapter);
        return v;
    }

}