package org.myleap.mlive.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;

import org.myleap.mlive.presenter.UnknowFragmentPresenter;

/**
 * Created by Jiangwendong on 2017/3/24.
 */

public class UnknowPageFragment extends BaseFragment {
    private UnknowFragmentPresenter mUnknowPageFragmentPresenter;
    private TextView mRootView;

    @Override
    protected View initView() {
        mRootView = new TextView(mActivity);
        return mRootView;
    }

    @Override
    protected void initData() {
        super.initData();
        mUnknowPageFragmentPresenter = new UnknowFragmentPresenter(this);
//        mUnknowPageFragmentPresenter.queryVideoFinalInfo(getJson(), new TypeToken<List<VideoFinalInfo>>() {
//        });
//        mUnknowPageFragmentPresenter.regiestUser("15986759007", "1234", "jwd");
//        mUnknowPageFragmentPresenter.startLive(getStartLiveParams());
        mUnknowPageFragmentPresenter.pro();
    }

    private String getStartLiveParams() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uid", "1");
        jsonObject.addProperty("accessToken", "");
        jsonObject.addProperty("video_title", "123");
        jsonObject.addProperty("thumb", "imgurl");
        jsonObject.addProperty("video_intro", "video_intro");
        return jsonObject.toString();
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
        mRootView.setText(data + "Unknow");
    }
}
