package edu.jsu.mcis.cs408.lab06;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;

    public static Fragment[] fragments = new Fragment[3];

    public TabLayoutAdapter(Fragment fragment) {

        super(fragment);
        fragments[0] = new FragmentTip();
        fragments[1] = new FragmentTemperature();
        fragments[2] = new FragmentDistance();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return fragments[position];

    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

}