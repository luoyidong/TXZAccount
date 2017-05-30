package com.txznet.account.base.mv.presenter;

import com.txznet.account.base.OnNextObservable;
import com.txznet.account.base.module.BluetoothManager;
import com.txznet.account.base.module.Injections;
import com.txznet.account.base.mv.contract.BluetoothContract;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class BluetoothPresenter implements BluetoothContract.Presenter {
    private BluetoothContract.View mView;

    private BluetoothManager mBtManager;

    private BluetoothManager.BluetoothStatusListener mListener = new BluetoothManager.BluetoothStatusListener() {
        @Override
        public void onLink(String phoneName) {
            if (mView != null) {
                mView.showPhoneName(phoneName);
            }
        }
    };

    public BluetoothPresenter() {
        mBtManager = Injections.provideBluetoothManager();
    }

    @Override
    public void onAttachView(BluetoothContract.View view) {
        mView = view;

        mBtManager.register(mListener);
        mView.showDeviceName(mBtManager.getDeviceName());
    }

    @Override
    public void onDetachView() {
        mBtManager.unRegister(mListener);
    }

    @Override
    public void next() {
        OnNextObservable.GLOBAL_OBSERVABLE.notifyOnNext();
    }
}