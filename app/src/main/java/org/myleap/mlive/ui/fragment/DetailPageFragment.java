package org.myleap.mlive.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.myleap.mlive.model.net.bean.Members;
import org.myleap.mlive.presenter.DetailFragmentPresenter;

import java.util.List;

/**
 * Created by Jiangwendong on 2017/3/24.
 */

public class DetailPageFragment extends BaseFragment {
    private DetailFragmentPresenter mDetailFragmentPresenter;
    private TextView mRootView;

    @Override
    protected View initView() {
        mRootView = new TextView(mActivity);
        return mRootView;
    }

    @Override
    protected void initData() {
        super.initData();
        mDetailFragmentPresenter = new DetailFragmentPresenter(this);
        mDetailFragmentPresenter.queryVideoFinalInfo(getJson(), new TypeToken<List<Members>>() {
        });
    }

    // 封装接口请求参数
    private String getJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "1");
        jsonObject.addProperty("fileId", "b687576030a54900acae02dd333b9a55");
        jsonObject.addProperty("userId", "1");
        jsonObject.addProperty("nickname", "1");
        return jsonObject.toString();
    }

    public void refreshView(String data) {
        mRootView.setText(data + "DetailPageFragment");
    }
}
