package com.example.admin.rtr.Historic_Call;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.example.admin.rtr.R;
import com.example.admin.rtr.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultsFragments extends Fragment
{
    private ViewPager viewPager;


    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        return li.inflate(R.layout.fragment_historic_call_results_main, vg, false);
    }

    public void onViewCreated(View v, Bundle bundle) {

        ((MainActivity)getActivity()).setActionBarTitle("Historic Call");

        ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPageAdapter(getActivity().getSupportFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip)v.findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);




    }

}