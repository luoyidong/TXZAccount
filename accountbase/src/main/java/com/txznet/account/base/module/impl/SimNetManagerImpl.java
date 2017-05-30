package com.txznet.account.base.module.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.txznet.account.base.module.Injections;
import com.txznet.account.base.module.SimNetManager;
import com.txznet.account.base.util.DeviceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TXZ-METEORLUO on 2017/5/19.
 */
public class SimNetManagerImpl implements SimNetManager {
    private static final String TAG = SimNetManagerImpl.class.getSimpleName();

    private ArrayList<OnSimNetChangeListener> mListeners = new ArrayList<>();

    private static SimNetManagerImpl sInstance = new SimNetManagerImpl();

    public static SimNetManagerImpl getInstance() {
        return sInstance;
    }

    private SimNetManagerImpl() {
        Injections.provideContext().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                notifySimStatus();
            }
        }, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
    }

    /**
     * 检查sim卡状态
     *
     * @return
     */
    private void notifySimStatus() {
        if (!DeviceUtil.isWifiConnect(Injections.provideContext())) {
            if (DeviceUtil.isSimAvaible()) {
                notifyStatusListener(OnSimNetChangeListener.STATE_HAVE_SIM);
            } else {
                // 没有SIM卡的话
                notifyStatusListener(OnSimNetChangeListener.STATE_NO_SIM);
            }
        } else {
            notifyStatusListener(OnSimNetChangeListener.STATE_NET_ALL_WELL);
        }
    }

    private void notifyStatusListener(int status) {
        for (OnSimNetChangeListener listener : mListeners) {
            listener.onChange(status);
        }
    }

    private void log(String txt) {
        Log.d(TAG, txt);
    }

    @Override
    public void requestState() {
        notifySimStatus();
    }

    @Override
    public void registerListener(OnSimNetChangeListener listener) {
        if (mListeners.contains(listener)) {
            return;
        }

        mListeners.add(listener);
    }

    @Override
    public void unRegisterListener(OnSimNetChangeListener listener) {
        if (mListeners.contains(listener)) {
            mListeners.remove(listener);
        }
    }
}