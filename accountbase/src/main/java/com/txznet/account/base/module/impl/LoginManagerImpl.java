package com.txznet.account.base.module.impl;

import com.txznet.account.base.module.LoginManager;

/**
 * Created by TXZ-METEORLUO on 2017/5/19.
 */
public class LoginManagerImpl implements LoginManager {

    private static LoginManagerImpl sInstance = new LoginManagerImpl();

    public static LoginManagerImpl getInstance() {
        return sInstance;
    }

    @Override
    public void login(String phone, String idcode) {

    }

    @Override
    public String getIdCode(String phone) {
        return null;
    }
}