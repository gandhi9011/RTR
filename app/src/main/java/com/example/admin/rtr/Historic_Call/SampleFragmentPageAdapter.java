package com.example.admin.rtr.Historic_Call;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;
import com.example.admin.rtr.R;

/**
 * Created by Admin on 19-07-2017.
 */
public class SampleFragmentPageAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

    private int tabIcons[] = {R.drawable.al,R.drawable.in, R.drawable.out, R.drawable.mis,R.drawable.vm};

    public SampleFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return tabIcons.length;
    }


    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AllResultFragments();
            case 1:
                return new IncomingResultsFragments();
            case 2:
                return new OutgoingResultsFragments();
            case 3:
                return new MissedResultsFragments();
            case 4:
                return new VoicemailResultsFragments();
        }

        return null;
    }
}
