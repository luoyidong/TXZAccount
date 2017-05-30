package com.txznet.account.base.module;

/**
 * Created by TXZ-METEORLUO on 2017/5/19.
 */
public interface SimNetManager {
    interface OnSimNetChangeListener {
        /**
         * 网络异常
         */
        int STATE_NET_ERROR = -2;
        /**
         * 没有SIM卡
         */
        int STATE_NO_SIM = -1;
        /**
         * 正在检测
         */
        int STATE_CHECKING = 0;
        /**
         * 有SIM卡
         */
        int STATE_HAVE_SIM = 1;
        /**
         * 网络良好
         */
        int STATE_NET_WELL = 2;

        /**
         * WIFI连接上
         */
        int STATE_NET_ALL_WELL = 3;

        void onChange(int status);
    }

    void requestState();

    void registerListener(OnSimNetChangeListener listener);

    void unRegisterListener(OnSimNetChangeListener listener);
}