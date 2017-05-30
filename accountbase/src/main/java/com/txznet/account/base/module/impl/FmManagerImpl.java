package com.txznet.account.base.module.impl;

import com.txznet.account.base.module.FmManager;

/**
 * Created by TXZ-METEORLUO on 2017/5/22.
 */
public class FmManagerImpl implements FmManager {

    private static FmManagerImpl sInstance = new FmManagerImpl();

    public static FmManagerImpl getInstance() {
        return sInstance;
    }

    @Override
    public void openFm(float val) {

    }

    @Override
    public void flushFm(float val) {
        if (isFmOpen()) {

        }
    }

    @Override
    public boolean isFmOpen() {
        return false;
    }
}