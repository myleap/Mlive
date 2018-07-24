package org.myleap.mlive.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.myleap.mlive.model.net.bean.Members;
import org.myleap.mlive.presenter.InteractFragmentPresenter;

import java.util.List;

/**
 * Created by Jiangwendong on 2017/3/24.
 */

public class InteractPageFragment extends BaseFragment {
    private InteractFragmentPresenter mInteractFragmentPresenter;
    private TextView mRootView;

    @Override
    protected View initView() {
        mRootView = new TextView(mActivity);
        return mRootView;
    }

    @Override
    protected void initData() {
        super.initData();
        mInteractFragmentPresenter = new InteractFragmentPresenter(this);
        mInteractFragmentPresenter.queryVideoFinalInfo(getJson(), new TypeToken<List<Members>>() {
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

    public void setView(String data) {
        mRootView.setText(data+"InteractPageFragment");
    }
}
