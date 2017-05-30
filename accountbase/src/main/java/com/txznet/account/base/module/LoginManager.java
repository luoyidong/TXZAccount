package com.txznet.account.base.module;

/**
 * Created by TXZ-METEORLUO on 2017/5/19.
 */
public interface LoginManager {

    void login(String phone, String idcode);

    String getIdCode(String phone);
}