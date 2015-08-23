package com.example.jigyasa.poll_khol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by jigyasa on 22/8/15.
 */
public class MyLogIn extends Activity{

    ImageButton fb, twitter, google;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylogin);
        fb = (ImageButton)findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Call login twitter function
                Intent i = new Intent(MyLogIn.this, MainActivity.class);
                startActivity(i);
            }
        });

        twitter = (ImageButton)findViewById(R.id.twitter);
        twitter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Call login twitter function
                Intent i = new Intent(MyLogIn.this,MainActivity.class);
                startActivity(i);
            }
        });


    }

}
