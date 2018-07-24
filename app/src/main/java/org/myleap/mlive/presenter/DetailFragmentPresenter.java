package org.myleap.mlive.presenter;

import com.google.gson.reflect.TypeToken;

import org.myleap.mlive.model.net.ResponeInfo;
import org.myleap.mlive.model.net.bean.Members;
import org.myleap.mlive.ui.fragment.DetailPageFragment;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by jwd on 2017/3/21.
 */

public class DetailFragmentPresenter extends BasePresenter {
    private DetailPageFragment mDetailPageFragment;

    public DetailFragmentPresenter(DetailPageFragment detailPageFragment) {
        mDetailPageFragment = detailPageFragment;
    }

    public void queryVideoFinalInfo(String params, TypeToken typeToken) {
        setTypeToken(typeToken);
        Call<ResponeInfo> call = mRequestApi.queryVideoFinalInfo(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params));
        call.enqueue(mCallback);
    }


    private Members mVideoFinalInfo;

    @Override
    protected void parserDatas(List<?> data) {
        mVideoFinalInfo = (Members) data.get(0);
        mDetailPageFragment.refreshView(mVideoFinalInfo.getName());
    }
}
