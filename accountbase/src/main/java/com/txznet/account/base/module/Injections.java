package com.txznet.account.base.module;

import android.content.Context;

import com.txznet.account.base.module.impl.BluetoothManagerImpl;
import com.txznet.account.base.module.impl.FmManagerImpl;
import com.txznet.account.base.module.impl.LoginManagerImpl;
import com.txznet.account.base.module.impl.SimNetManagerImpl;

/**
 * Created by TXZ-METEORLUO on 2017/5/19.
 */
public class Injections {
    private static Context sContext;

    public static SimNetManager provideSimNetManager() {
        return SimNetManagerImpl.getInstance();
    }

    public static LoginManager provideLoginManager() {
        return LoginManagerImpl.getInstance();
    }

    public static FmManager provideFmManager() {
        return FmManagerImpl.getInstance();
    }

    public static BluetoothManagerImpl provideBluetoothManager() {
        return BluetoothManagerImpl.getInstance();
    }

    public static void init(Context context) {
        sContext = context;
    }

    public static Context provideContext() {
        return sContext;
    }
}