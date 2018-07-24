package org.myleap.mlive.presenter;

import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.myleap.mlive.model.net.RequestApi;
import org.myleap.mlive.model.net.ResponeInfo;
import org.myleap.mlive.utils.Constants;
import org.myleap.mlive.utils.MliveApp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jwd on 2017/3/21.
 */

public abstract class BasePresenter {

    protected Retrofit mRetrofit;
    protected RequestApi mRequestApi;
    protected Gson mGson;
    private TypeToken mTypeToken;

    public BasePresenter() {
        //使用Retrofit
        mRetrofit = new Retrofit.Builder().baseUrl(Constants.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mRequestApi = mRetrofit.create(RequestApi.class);
        mGson = new GsonBuilder().create();
    }

    public void setTypeToken(TypeToken typeToken) {
        mTypeToken = typeToken;
    }

    protected Callback mCallback = new Callback<ResponeInfo>() {
        @Override
        public void onResponse(Call<ResponeInfo> call, Response<ResponeInfo> response) {
            ResponeInfo responseInfo = response.body();
            if (responseInfo.resCode.equals("200")) {
                //访问成功，开始解析数据
                String s = mGson.toJson(responseInfo.objects);
                List<?> dataBeans = mGson.fromJson(s, mTypeToken.getType());
                parserDatas(dataBeans);
            } else if (responseInfo.resCode.equals("1")) {
                Toast.makeText(MliveApp.sInstance, "服务器哥们，你又写错了", Toast.LENGTH_SHORT).show();
            } else if (responseInfo.resCode.equals("-1")) {
                Toast.makeText(MliveApp.sInstance, "数据为空", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MliveApp.sInstance, responseInfo.resMsg, Toast.LENGTH_SHORT).show();
                onFailure(call, new RuntimeException(responseInfo.resMsg));
            }
        }

        @Override
        public void onFailure(Call<ResponeInfo> call, Throwable t) {
            //Toast.makeText(TakeoutApp.sInstance, "压根没有连上服务器", Toast.LENGTH_SHORT).show();
        }
    };

    protected abstract void parserDatas(List<?> datas);
}
