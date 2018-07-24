package org.myleap.mlive.presenter;

import com.google.gson.reflect.TypeToken;

import org.myleap.mlive.model.net.ResponeInfo;
import org.myleap.mlive.model.net.bean.Members;
import org.myleap.mlive.ui.fragment.MoreFragment;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by jwd on 2017/3/21.
 */

public class MoreFragmentPresenter extends BasePresenter {
    private MoreFragment mMoreFragment;

    public MoreFragmentPresenter(MoreFragment homeFragment) {
        mMoreFragment = homeFragment;
    }

    public void queryRxjava(String params) {
        mRequestApi.postRxJava(RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                params))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponeInfo>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        mMoreFragment.setView("onSubscribe");
                    }

                    @Override
                    public void onNext(ResponeInfo responseInfo) {
                        String s = mGson.toJson(responseInfo.objects);
                        List<Members> videoFinalInfos = mGson.fromJson(s, new TypeToken<List<Members>>() {
                        }.getType());
                        mMoreFragment.setView(videoFinalInfos.get(0).getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMoreFragment.setView(e.toString());
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
