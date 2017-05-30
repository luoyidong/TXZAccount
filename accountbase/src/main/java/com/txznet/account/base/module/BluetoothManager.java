package com.txznet.account.base.module;

/**
 * Created by TXZ-METEORLUO on 2017/5/23.
 */
public interface BluetoothManager {

    interface BluetoothStatusListener {

        void onLink(String phoneName);

    }

    String isLink();

    String getDeviceName();

    void register(BluetoothStatusListener listener);

    void unRegister(BluetoothStatusListener listener);
}
