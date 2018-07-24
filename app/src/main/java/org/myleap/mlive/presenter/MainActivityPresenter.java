package org.myleap.mlive.presenter;

import org.myleap.mlive.ui.activity.MainActivity;

import java.util.List;

/**
 * Created by jwd on 2017/3/21.
 */

public class MainActivityPresenter extends BasePresenter {
    private MainActivity mMainActivity;

    public MainActivityPresenter(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Override
    protected void parserDatas(List<?> datas) {

    }
}