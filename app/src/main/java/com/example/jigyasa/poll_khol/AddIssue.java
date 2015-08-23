package com.example.jigyasa.poll_khol;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddIssue extends ActionBarActivity implements View.OnClickListener {

    Button cancel;
    Button done;
    EditText title;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Issue");

        setContentView(R.layout.activity_add_issue);
        cancel = (Button) findViewById(R.id.cancel);
        done = (Button) findViewById(R.id.done);
        cancel.setOnClickListener(this);
        done.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_add_issue, menu);
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

    @Override
    public void onClick(View view) {
        Intent intent=new Intent();
        switch (view.getId()) {
            case R.id.done:
                title=(EditText) findViewById(R.id.title);
                String title_value=""+title.getText();
                description=(EditText) findViewById(R.id.description);
                String desc=""+description.getText();
                ProblemBox pm=new ProblemBox(title_value,desc);
                pm.save();

                intent.putExtra("title",title_value);
                intent.putExtra("description",desc);
                break;
            case R.id.cancel:
                finish();
                break;
            default:
                break;
        }
       // Intent data=new Intent();
        setResult(1,intent);
        finish();
    }
}
