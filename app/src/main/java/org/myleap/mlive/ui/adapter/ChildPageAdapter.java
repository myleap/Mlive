package org.myleap.mlive.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.myleap.mlive.ui.fragment.DetailPageFragment;
import org.myleap.mlive.ui.fragment.InteractPageFragment;
import org.myleap.mlive.ui.fragment.UnknowPageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiangwendong on 2017/3/24.
 */

public class ChildPageAdapter extends FragmentPagerAdapter {

    private String[] mTitles = new String[]{"详情", "互动", "附件"};
    private List<Fragment> mFragmentList;

    public ChildPageAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new DetailPageFragment());
        mFragmentList.add(new InteractPageFragment());
        mFragmentList.add(new UnknowPageFragment());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


    @Override
    public Fragment getItem(int position) {
        if (mFragmentList != null) {
            return mFragmentList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (mFragmentList != null) {
            return mFragmentList.size();
        }
        return 0;
    }
}
