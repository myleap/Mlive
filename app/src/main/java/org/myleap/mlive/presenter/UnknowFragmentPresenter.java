package org.myleap.mlive.presenter;

import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.myleap.mlive.model.net.RequestApi;
import org.myleap.mlive.model.net.ResponeInfo;
import org.myleap.mlive.model.net.bean.Members;
import org.myleap.mlive.model.net.bean.User;
import org.myleap.mlive.ui.fragment.UnknowPageFragment;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jwd on 2017/3/21.
 */

public class UnknowFragmentPresenter extends BasePresenter {
    private UnknowPageFragment mUnknowPageFragment;

    public UnknowFragmentPresenter(UnknowPageFragment unknowPageFragment) {
        mUnknowPageFragment = unknowPageFragment;
    }

    public void queryVideoFinalInfo(String params, TypeToken typeToken) {
        setTypeToken(typeToken);
        Call<ResponeInfo> call = mRequestApi.queryVideoFinalInfo(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params));
        call.enqueue(mCallback);
    }

    public void pro() {
        Retrofit re = new Retrofit.Builder()
//                .addConverterFactory(ProtoConverterFactory.create())
                .baseUrl("http://172.16.201.219:8080/myTestProject/").build();
        RequestApi requestApi = re.create(RequestApi.class);
        Callback<ResponseBody> responeInfoCallback = new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                User.UserModel model = null;
                try {
                    model = User.UserModel.parseFrom(response.body().bytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("aaaaa",model.getName());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                    String s="";
            }
        };
        Call<ResponseBody> call = requestApi.pro();
        call.enqueue(responeInfoCallback);
    }

    public void startLive(String params) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.16.200.118/myleapAdmin/index.php/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mRequestApi = retrofit.create(RequestApi.class);
        mRequestApi.startLive(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                params))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponeInfo>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        mUnknowPageFragment.setView("onSubscribe");
                    }

                    @Override
                    public void onNext(ResponeInfo responseInfo) {
                        Log.d("123", responseInfo.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mUnknowPageFragment.setView(e.toString());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void regiestUser(String mobile, String code, String nickname) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.16.200.222/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mRequestApi = retrofit.create(RequestApi.class);
        mRequestApi.regiestUser(mobile, code, nickname)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponeInfo>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        mUnknowPageFragment.setView("onSubscribe");
                    }

                    @Override
                    public void onNext(ResponeInfo responseInfo) {
                        Log.d("123", responseInfo.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mUnknowPageFragment.setView(e.toString());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private Members mVideoFinalInfo;

    @Override
    protected void parserDatas(List<?> data) {
        mVideoFinalInfo = (Members) data.get(0);
        mUnknowPageFragment.setView(mVideoFinalInfo.getName());
    }
}
