package org.myleap.mlive.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;

import org.myleap.mlive.presenter.MoreFragmentPresenter;

/**
 * Created by Jiangwendong on 2017/3/22.
 */
public class MoreFragment extends BaseFragment {
    TextView tv;
    private MoreFragmentPresenter mMoreFragmentPresenter;
    @Override
    protected View initView() {
       tv = new TextView(mActivity);
        return tv;
    }

    @Override
    protected void initData() {
        super.initData();
        mMoreFragmentPresenter = new MoreFragmentPresenter(this);
        mMoreFragmentPresenter.queryRxjava(getJson());
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
        tv.setText(data);
    }
}
