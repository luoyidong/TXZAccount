package com.txznet.account.base.ui;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public interface BaseContract {
    interface View {

    }

    interface Presenter<V extends View> {
        void onAttachView(V v);

        void onDetachView();

        void next();
    }
}