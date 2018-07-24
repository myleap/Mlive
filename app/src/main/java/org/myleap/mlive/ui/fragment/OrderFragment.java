package org.myleap.mlive.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import org.myleap.mlive.R;
import org.myleap.mlive.ui.adapter.ChildPageAdapter;


/**
 * Created by Jiangwendong on 2017/3/22.
 */
public class OrderFragment extends BaseFragment {
    private TabLayout mTab;
    private ViewPager mViewPager;


    @Override
    protected View initView() {
        View orderView = View.inflate(mActivity, R.layout.fragment_order, null);
        mTab = (TabLayout) orderView.findViewById(R.id.order_tab);
        mViewPager = (ViewPager) orderView.findViewById(R.id.order_viewpager);
        mTab.setupWithViewPager(mViewPager);
        ChildPageAdapter bizPageAdapter = new ChildPageAdapter(getChildFragmentManager());
//        WeiboTimelineFragment.newInstance(type);
//        bizPageAdapter.setFragmentList(mFragmentList);
        mViewPager.setAdapter(bizPageAdapter);
        mTab.setupWithViewPager(mViewPager);
        return orderView;
    }
}
