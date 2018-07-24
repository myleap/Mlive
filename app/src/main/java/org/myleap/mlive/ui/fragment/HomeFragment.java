package org.myleap.mlive.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.myleap.mlive.model.net.bean.Members;
import org.myleap.mlive.presenter.HomeFragmentPresenter;

import java.util.List;

/**
 * Created by Jiangwendong on 2017/3/22.
 */
public class HomeFragment extends BaseFragment {
    HomeFragmentPresenter mHomeFragmentPresenter;
    TextView tv;

    @Override
    protected View initView() {
        tv = new TextView(mActivity);
        return tv;
    }

    @Override
    protected void initData() {
        super.initData();
        mHomeFragmentPresenter = new HomeFragmentPresenter(this);
        mHomeFragmentPresenter.queryVideoFinalInfo(getJson(), new TypeToken<List<Members>>() {
        });
    }

    private String getJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "1");
        jsonObject.addProperty("fileId", "b687576030a54900acae02dd333b9a55");
        jsonObject.addProperty("userId", "1");
        jsonObject.addProperty("nickname", "1");
        return jsonObject.toString();
    }

    public void setView(String tvData) {
        tv.setText(tvData);
    }
}
