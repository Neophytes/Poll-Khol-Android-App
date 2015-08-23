package com.example.jigyasa.poll_khol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ManifestAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Manifesto> manifestoList;
    public ManifestAdapter(Context context, int resource,ArrayList<Manifesto> manifestoList)
    {
       // super(context, resource);
      //  super();
        this.context=context;
        this.manifestoList=manifestoList;
    }

    @Override
    public int getCount() {
        return manifestoList.size();
    }

    @Override
    public Object getItem(int i) {
        return manifestoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

           LayoutInflater inflater = (LayoutInflater) context
                   .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(R.layout.listview_item, null);

        Manifesto manifesto=manifestoList.get(position);
        TextView title=(TextView)convertView.findViewById(R.id.manifesto_title);
        TextView upcount=(TextView)convertView.findViewById(R.id.upvote);
        TextView downcount=(TextView)convertView.findViewById(R.id.downvote);
        upcount.setText(manifesto.up+"");
        downcount.setText(manifesto.down+"");
        title.setText(manifesto.title);

        return convertView;
    }
}
