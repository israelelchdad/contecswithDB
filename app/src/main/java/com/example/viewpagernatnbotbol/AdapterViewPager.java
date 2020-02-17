package com.example.viewpagernatnbotbol;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class AdapterViewPager extends FragmentStatePagerAdapter {
    ArrayList<MycontectsFragment>myfragments;
    public AdapterViewPager(@NonNull FragmentManager fm, ArrayList<MycontectsFragment>fragments) {
        super(fm);
        this.myfragments = fragments;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myfragments.get(position);
    }

    @Override
    public int getCount() {
        return myfragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "favirite";
        }
        else if (position == 1)
        {
            title = "simplecontects";
        }


        return title;
    }
}
