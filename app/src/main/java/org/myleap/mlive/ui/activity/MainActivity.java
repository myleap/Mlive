package org.myleap.mlive.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import org.myleap.mlive.R;
import org.myleap.mlive.ui.fragment.HomeFragment;
import org.myleap.mlive.ui.fragment.MoreFragment;
import org.myleap.mlive.ui.fragment.OrderFragment;
import org.myleap.mlive.ui.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FrameLayout mainFragmentContainer;
    private LinearLayout mainBottomeSwitcherContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragmentContainer = findViewById(R.id.main_fragment_container);
        mainBottomeSwitcherContainer =  findViewById(R.id.main_bottome_switcher_container);
        initFragment();
        initBottom();
        changeUi(0);
    }

    private String[] mTitles = new String[]{"首页", "订单", "用户", "更多"};
    private List<Fragment> mFragmentList = new ArrayList<>();

    private void initFragment() {
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new OrderFragment());
        mFragmentList.add(new UserFragment());
        mFragmentList.add(new MoreFragment());
    }

    private void initBottom() {
        int count = mainBottomeSwitcherContainer.getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = mainBottomeSwitcherContainer.getChildAt(i);
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = mainBottomeSwitcherContainer.indexOfChild(child);
                    changeUi(index);
                }
            });
        }
    }

    private void changeUi(int index) {
        //选中的条目为蓝色，但是是disable状态
        int count = mainBottomeSwitcherContainer.getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = mainBottomeSwitcherContainer.getChildAt(i);
            if (i == index) {
                //需要禁用它，蓝色
                setEnable(child, false);
            } else {
                //灰色
                setEnable(child, true);
            }
        }
        //切换fragment
        getSupportFragmentManager().beginTransaction().
                replace(R.id.main_fragment_container, mFragmentList.get(index)).commit();
    }

    private void setEnable(View child, boolean isEnable) {
        child.setEnabled(isEnable);
        //禁用或者启用孩子,因为禁用父视图不会主动禁用子视图
        if (child instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) child;
            for (int j = 0; j < viewGroup.getChildCount(); j++) {
                View item = viewGroup.getChildAt(j);
                setEnable(item, isEnable);
            }
        }
    }
}
