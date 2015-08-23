package com.example.jigyasa.poll_khol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.SharingHelper;

/**
 * Created by chhavi on 22/8/15.
 */
public class ManifestoItemDetail extends AppCompatActivity implements Serializable

{
    Manifesto manifesto;
    TextView tile;
    TextView content;
    TextView upvotes;
    TextView downvotes;
    ArrayAdapter<String> adapter;
    Button commentButton;
    ArrayList<String> list;
    Button submitButton;
    LinearLayout dynamicLinearLayout;
    ListView listView;
    EditText et;
    ImageView up;
    ImageView down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_manifest_item_detail);
        Intent intent = getIntent();
        // manifesto=(Manifesto)intent.getSerializableExtra("manifesto");
        manifesto = ManifestoFragment.sendManifesto;
        tile = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        upvotes = (TextView) findViewById(R.id.upvote);
        downvotes = (TextView) findViewById(R.id.downvote);
        commentButton = (Button) findViewById(R.id.comment_button);
        submitButton = (Button) findViewById(R.id.submit_button);
        up = (ImageView) findViewById(R.id.up);
        down = (ImageView) findViewById(R.id.down);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ManifestoFragment.sendManifesto.up++;
                upvotes.setText(ManifestoFragment.sendManifesto.up + "");
                manifesto.up = ManifestoFragment.sendManifesto.up;
                manifesto.save();
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ManifestoFragment.sendManifesto.down++;
                downvotes.setText(ManifestoFragment.sendManifesto.down + "");
                manifesto.down = ManifestoFragment.sendManifesto.down;
                manifesto.save();
            }
        });

        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, list);
        et = (EditText) findViewById(R.id.edit_text);

        dynamicLinearLayout = (LinearLayout) findViewById(R.id.dynamicLinearLayout);
        listView = (ListView) findViewById(R.id.dynamic_listview);

        // listView.setAdapter(adapter);
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setVisibility(View.VISIBLE);
                et.setText("");
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = new TextView(getBaseContext());
                list.add(et.getText().toString());
                if (list.size() == 1)
                    listView.setAdapter(adapter);

                adapter.notifyDataSetChanged();
                et.setVisibility(View.GONE);
            }
        });
        setData();
        setResult(1);

        TextView shareBtn = (TextView) findViewById(R.id.sharBtn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            JSONObject obj = new JSONObject();
                                            try {
                                                obj.put("product_id", "1234");
                                                obj.put("product_name", "Poll Khol");
                                                obj.put("$og_title", "Poll Khol");
                                                obj.put("$og_description", "Hi ! Check out Poll Khol  :)");
                                                obj.put("$og_image_url", "http://neophytes.github.io");
                                            } catch (JSONException ex) {
                                                ex.printStackTrace();
                                            }

                                            new Branch.ShareLinkBuilder(ManifestoItemDetail.this, obj)
                                                    .addPreferredSharingOption(SharingHelper.SHARE_WITH.FACEBOOK)
                                                    .addPreferredSharingOption(SharingHelper.SHARE_WITH.EMAIL)
                                                    .addPreferredSharingOption(SharingHelper.SHARE_WITH.MESSAGE)
                                                    .addPreferredSharingOption(SharingHelper.SHARE_WITH.TWITTER)
                                                    .setMessage("Hey! Check out this manifesto point!")
                                                    .setStage("post_purchase")
                                                    .setFeature("share")
                                                    .addTag("version_213")
                                                    .setDefaultURL("http://neophytes.github.io")
                                                    .setCallback(new Branch.BranchLinkShareListener() {
                                                        @Override
                                                        public void onLinkShareResponse(String sharedLink, String sharedChannel, BranchError error) {
                                                            if (error != null) {
                                                                Log.i("BranchTestBed", "onLinkShareResponse... " + sharedLink + " " + sharedChannel + " " + error.getMessage());
                                                            } else {
                                                                Log.i("BranchTestBed", "onLinkShareResponse... " + sharedLink + " " + sharedChannel);
                                                            }
                                                        }

                                                        @Override
                                                        public void onChannelSelected(String channelName) {
                                                            Log.i("BranchTestBed", "onChannelSelected... " + channelName);
                                                        }
                                                    })
                                                    .shareLink();

                                        }

                                    }
        );
    }
    void setData()
    {
        tile.setText(ManifestoFragment.sendManifesto.title);
        content.setText(ManifestoFragment.sendManifesto.description);
        upvotes.setText(ManifestoFragment.sendManifesto.up + "");
        downvotes.setText(ManifestoFragment.sendManifesto.down + "");
    }


}
