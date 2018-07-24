package org.myleap.mlive.presenter;

import com.google.gson.reflect.TypeToken;

import org.myleap.mlive.model.net.ResponeInfo;
import org.myleap.mlive.model.net.bean.Members;
import org.myleap.mlive.ui.fragment.HomeFragment;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by jwd on 2017/3/21.
 */

public class HomeFragmentPresenter extends BasePresenter {
    private HomeFragment mHomeFragment;

    public HomeFragmentPresenter(HomeFragment homeFragment) {
        mHomeFragment = homeFragment;
    }

    public void queryVideoFinalInfo(String params, TypeToken typeToken) {
        setTypeToken(typeToken);
        Call<ResponeInfo> call = mRequestApi.queryVideoFinalInfo(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params));
        call.enqueue(mCallback);
    }


    private Members mVideoFinalInfo;

    @Override
    protected void parserDatas(List<?> data) {
//        mHomeFragment.setView(data);
//        Gson gson = new GsonBuilder().create();
//        List<VideoFinalInfo> videoFinalInfos = gson.fromJson(data, new TypeToken<List<VideoFinalInfo>>() {
//        }.getType());
        mVideoFinalInfo = (Members) data.get(0);
        mHomeFragment.setView(mVideoFinalInfo.getName());
    }
}
