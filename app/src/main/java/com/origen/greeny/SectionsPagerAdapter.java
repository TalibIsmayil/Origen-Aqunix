package com.origen.greeny;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.origen.greeny.Fragments.DetailFragment;
import com.origen.greeny.Fragments.HomeFragment;
import com.origen.greeny.Fragments.NotificationFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    private String id;

    public SectionsPagerAdapter(Context context, FragmentManager fm,String id) {
        super(fm);
        this.id = id;
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a CommonFragment (defined as a static inner class below).
        if (position == 0) {
            return  DetailFragment.newInstance(id);
        } else {
            return new NotificationFragment(id);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}