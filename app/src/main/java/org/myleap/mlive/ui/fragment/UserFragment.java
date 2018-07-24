package org.myleap.mlive.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;

import org.myleap.mlive.presenter.UserFragmentPresenter;

/**
 * Created by Jiangwendong on 2017/3/22.
 */
public class UserFragment extends BaseFragment {
    TextView tv;
    private UserFragmentPresenter mUserFragmentPresenter;

    @Override
    protected View initView() {
        tv = new TextView(mActivity);
        return tv;
    }

    @Override
    protected void initData() {
        super.initData();
        mUserFragmentPresenter = new UserFragmentPresenter(this);
        mUserFragmentPresenter.regiestUser(getJson());
    }
    // 封装接口请求参数
    private String getJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("mobile", "15986759007");
        jsonObject.addProperty("code", "1234");
        jsonObject.addProperty("nickname", "1");
        return jsonObject.toString();
    }
    public void setView(String data) {
        tv.setText(data);
    }
}
