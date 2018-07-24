package org.myleap.mlive.presenter;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.myleap.mlive.model.net.RequestApi;
import org.myleap.mlive.model.net.ResponeInfo;
import org.myleap.mlive.ui.fragment.UserFragment;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jwd on 2017/3/21.
 */

public class UserFragmentPresenter extends BasePresenter {
    private UserFragment mUserFragment;

    public UserFragmentPresenter(UserFragment userFragment) {
        mUserFragment = userFragment;
    }

    public void regiestUser(String params) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://172.16.200.222/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mRequestApi = retrofit.create(RequestApi.class);
        mRequestApi.regiestUser(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponeInfo>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        mUserFragment.setView("onSubscribe");
                    }

                    @Override
                    public void onNext(ResponeInfo responseInfo) {
                        Log.d("123", responseInfo.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mUserFragment.setView(e.toString());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    protected void parserDatas(List<?> data) {
    }
}
