package com.txznet.account.base.mv.presenter;

import android.text.TextUtils;

import com.txznet.account.base.BaseContract;
import com.txznet.account.base.OnNextObservable;
import com.txznet.account.base.module.FmManager;
import com.txznet.account.base.module.Injections;
import com.txznet.account.base.mv.contract.FmContract;

import java.util.Calendar;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class FmPresenter implements FmContract.Presenter {
    private FmManager mFmManager;

    public FmPresenter() {
        mFmManager = Injections.provideFmManager();
    }

    @Override
    public void onAttachView(FmContract.View view) {

    }

    @Override
    public void onDetachView() {

    }

    @Override
    public void next() {
        OnNextObservable.GLOBAL_OBSERVABLE.notifyOnNext();
    }

    @Override
    public void openFm(String val) {
        if (!TextUtils.isEmpty(val)) {
            try {
                mFmManager.openFm(Float.parseFloat(val));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void flushFm(String val) {
        if (!TextUtils.isEmpty(val)) {
            try {
                mFmManager.flushFm(Float.parseFloat(val));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
