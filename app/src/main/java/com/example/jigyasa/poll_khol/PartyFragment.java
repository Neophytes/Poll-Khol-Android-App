package com.example.jigyasa.poll_khol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by chhavi on 21/8/15.
 */
public class PartyFragment extends Fragment {
    Bundle b;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.party_layout,null);
        ViewPager pager = (ViewPager) v.findViewById(R.id.pager);
        pager.setAdapter(new PartyAdapter(getChildFragmentManager()));
        b = new Bundle();
        //   b  = getArguments();
        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) v.findViewById(R.id.tabs);
        tabs.setViewPager(pager);
        return v;
    }


    public class PartyAdapter extends FragmentPagerAdapter {

        public PartyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // return TITLES[position];
            switch(position){
                case 0:
                    return "MANIFESTO";
                case 1:
                    return "CANDIDATES";
                case 2:
                    return "PROBLEM BOX";
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {

            switch(position){
                case 0:
                    ManifestoFragment manifesto0Fragment = new ManifestoFragment();
                    b.putInt("index", 1);
                    manifesto0Fragment.setArguments(b);
                    return  manifesto0Fragment;
                // break;
                case 1:
                    CandidatesFragment candidatesFragment = new CandidatesFragment();
                    b.putInt("index", 1);
                    candidatesFragment.setArguments(b);
                    return  candidatesFragment;
                //   return new CandidatesFragment();
                // CandidatesFragment candidatesFragment = new CandidatesFragment();
                //   Bundle b = new Bundle();
                //    b.putInt("index",0);
                //     Log.e("index", "" + b.getInt("index"));
                //    candidatesFragment.setArguments(b);
                // return candidatesFragment;
                case 2:
                    ProblemBoxFragment problemBoxFragment = new ProblemBoxFragment();
                    b.putInt("index", 1);
                    problemBoxFragment.setArguments(b);
                    return problemBoxFragment;
                //  return new ProblemBoxFragment();
            }
            return new CandidatesFragment();
        }

    }
}
