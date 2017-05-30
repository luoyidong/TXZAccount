package com.txznet.account.base.mv.presenter;

import com.txznet.account.base.BaseContract;
import com.txznet.account.base.OnNextObservable;
import com.txznet.account.base.mv.contract.WakeupContract;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class WakeupPresenter implements WakeupContract.Presenter {

    @Override
    public void onAttachView(WakeupContract.View view) {

    }

    @Override
    public void onDetachView() {

    }

    @Override
    public void next() {
        OnNextObservable.GLOBAL_OBSERVABLE.notifyOnNext();
    }
}