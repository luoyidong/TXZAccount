package com.txznet.account.base.module;

/**
 * Created by TXZ-METEORLUO on 2017/5/22.
 */
public interface FmManager {

    void openFm(float val);

    void flushFm(float val);

    boolean isFmOpen();
}