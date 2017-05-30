package com.txznet.account.base.module.impl;

import com.txznet.account.base.module.BluetoothManager;

import java.util.ArrayList;

/**
 * Created by TXZ-METEORLUO on 2017/5/23.
 */
public class BluetoothManagerImpl implements BluetoothManager {

    private ArrayList<BluetoothStatusListener> mListeners = new ArrayList<>();

    private static BluetoothManagerImpl sImpl = new BluetoothManagerImpl();

    public static BluetoothManagerImpl getInstance() {
        return sImpl;
    }

    @Override
    public String isLink() {
        return null;
    }

    @Override
    public String getDeviceName() {
        return null;
    }

    @Override
    public void register(BluetoothStatusListener listener) {
        if (!mListeners.contains(listener)) {
            mListeners.add(listener);
        }
    }

    @Override
    public void unRegister(BluetoothStatusListener listener) {
        if (mListeners.contains(listener)) {
            mListeners.remove(listener);
        }
    }
}