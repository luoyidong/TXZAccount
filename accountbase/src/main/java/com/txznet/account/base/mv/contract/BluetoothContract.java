package com.txznet.account.base.mv.contract;

import com.txznet.account.base.ui.BaseContract;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public interface BluetoothContract {

    interface View extends BaseContract.View {
        void showConnecting();

        void showConnected();

        void showDeviceName(String name);

        void showPhoneName(String name);
    }

    interface Presenter extends BaseContract.Presenter<View> {

    }
}