package com.example.jigyasa.poll_khol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;

public class MainActivity extends MaterialNavigationDrawer {

MaterialAccount account;
    @Override
    public void init(Bundle savedInstanceState) {
        account = new MaterialAccount(this.getResources(), "User ABCXYZ",null,null,R.drawable.user);
        this.addAccount(account);
       // PartyFragment aapFragment = new PartyFragment();


      //  a.putInt("index", 0);
     //   //aapFragment.setArguments(a);
        this.addSection(newSection("Aam Aadmi Party", R.drawable.abc_btn_radio_material, new AapFragment()));
        this.addSection(newSection("Bhartiya Janta Party", R.drawable.abc_btn_radio_material , new PartyFragment()));
        this.addSection(newSection("Congress", R.drawable.abc_btn_radio_material , new CongressFragment()));
        this.addSection(newSection("About Us", R.drawable.abc_btn_radio_material , new AboutUs()));

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
