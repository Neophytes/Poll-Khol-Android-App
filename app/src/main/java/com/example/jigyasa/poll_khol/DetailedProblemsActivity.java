package com.example.jigyasa.poll_khol;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class DetailedProblemsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_problems);
        Intent data=getIntent();
        Bundle b=data.getExtras();
        String title=b.getString("title");
        final ProblemBox problemBox= (ProblemBox) ProblemBox.find(ProblemBox.class,"title = ?",title);
        TextView titleBox=(TextView)findViewById(R.id.title);
        titleBox.setText(title);

        TextView description=(TextView)findViewById(R.id.description);
        description.setText(problemBox.description);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,problemBox.comments);
        ListView lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

        Button button=(Button)findViewById(R.id.upvotes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                problemBox.upvote =problemBox.upvote + 1;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_detailed_problems, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
