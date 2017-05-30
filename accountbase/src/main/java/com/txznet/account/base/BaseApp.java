package com.txznet.account.base;

import android.app.Application;

import com.txznet.account.base.module.Injections;

/**
 * Created by TXZ-METEORLUO on 2017/5/19.
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injections.init(this);
    }
}