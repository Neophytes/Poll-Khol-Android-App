package com.example.jigyasa.poll_khol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.SharingHelper;

/**
 * Created by jigyasa on 22/8/15.
 */
public class AboutUs  extends Fragment{
    Branch branch;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.about_us_layout,null);

        JSONObject obj = new JSONObject();
        try {
            obj.put("article_id", "1234");
            obj.put("$og_title", "Poll Khol");
            obj.put("$og_image_url", "http://neophytes.github.io/PollKhol.png");
            obj.put("$desktop_url", "http://neophytes.github.io/PollKhol.png");
        } catch (Exception ignore) { }

     /*   branch = new Branch();
        branch.getShortUrl(obj, "sms", "share", new Branch.BranchLinkCreateListener() {
            @Override
            public void onLinkCreate(String url, BranchError error) {
                Log.i("my activity", "Ready to share my link = " + url);
            }
        });*/



        Button shareButton = (Button)v.findViewById(R.id.button);
        shareButton.setOnClickListener(new View.OnClickListener() {
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

                new Branch.ShareLinkBuilder(getActivity(), obj)
                        .addPreferredSharingOption(SharingHelper.SHARE_WITH.FACEBOOK)
                        .addPreferredSharingOption(SharingHelper.SHARE_WITH.EMAIL)
                        .addPreferredSharingOption(SharingHelper.SHARE_WITH.MESSAGE)
                        .addPreferredSharingOption(SharingHelper.SHARE_WITH.TWITTER)
                        .setMessage("Hi ! Check out Poll Khol  :)")
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
        });
        return v;
    }

}
