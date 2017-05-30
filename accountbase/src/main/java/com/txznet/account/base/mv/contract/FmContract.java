package com.txznet.account.base.mv.contract;

import com.txznet.account.base.BaseContract;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public interface FmContract {

    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter<View> {

        void openFm(String val);

        void flushFm(String val);
    }
}
