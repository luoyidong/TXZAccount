package com.txznet.account.base.mv.presenter;

import com.txznet.account.base.OnNextObservable;
import com.txznet.account.base.mv.contract.GuideContract;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class GuidePresenter implements GuideContract.Presenter {
    GuideContract.View mView;

    public GuidePresenter() {
    }

    @Override
    public void onAttachView(GuideContract.View view) {
        mView = view;

        if (mView != null) {
            mView.showDisclaimer("file:///android_asset/disclaimer.html");
        }
    }

    @Override
    public void onDetachView() {
        mView = null;
    }

    @Override
    public void next() {
        // 关闭界面
        OnNextObservable.GLOBAL_OBSERVABLE.notifyOnEnd();
    }
}
