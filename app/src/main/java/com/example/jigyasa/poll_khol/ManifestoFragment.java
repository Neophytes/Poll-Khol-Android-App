package com.example.jigyasa.poll_khol;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

/**
 * Created by chhavi on 21/8/15.
 */
public class ManifestoFragment extends Fragment
{
    ArrayList<Manifesto> data;
    ManifestAdapter manifestAdapter;
    public static Manifesto sendManifesto;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.manifesto_layout,null);

        ListView manifestList=(ListView)view.findViewById(R.id.manifest_list);
        Bundle b=getArguments();
        int index=b.getInt("index");
       data =new ArrayList<>();
        List<Manifesto> manifestoList =Manifesto.listAll(Manifesto.class);
        if(index==0){
            for(int i=0;i<5;i++)
                data.add(manifestoList.get(i));
        }
        else if(index==1){
            for(int i=5;i<10;i++)
                data.add(manifestoList.get(i));
        }
        else{
            for(int i=10;i<15;i++)
                data.add(manifestoList.get(i));
        }
        manifestAdapter=new ManifestAdapter(getActivity(),0,data);
        manifestList.setAdapter(manifestAdapter);
        manifestList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent=new Intent();
                intent.setClass(getActivity(),ManifestoItemDetail.class);
                //intent.putExtra("manifesto",manifestoList.get(i));
                sendManifesto = data.get(i);
                startActivityForResult(intent,1);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        manifestAdapter.notifyDataSetChanged();
    }

}

