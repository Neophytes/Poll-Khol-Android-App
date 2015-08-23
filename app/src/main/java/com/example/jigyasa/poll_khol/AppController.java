package com.example.jigyasa.poll_khol;

import com.orm.SugarApp;

import io.branch.referral.Branch;

/**
 * Created by jigyasa on 22/8/15.
 */
public class AppController extends SugarApp {
    public void onCreate() {
        super.onCreate();
        Branch.getAutoInstance(this);
    }

}
