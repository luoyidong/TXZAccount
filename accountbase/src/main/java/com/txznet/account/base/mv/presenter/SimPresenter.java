package com.txznet.account.base.mv.presenter;

import com.txznet.account.base.OnNextObservable;
import com.txznet.account.base.module.Injections;
import com.txznet.account.base.module.SimNetManager;
import com.txznet.account.base.mv.contract.SimContract;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class SimPresenter implements SimContract.Presenter {

    SimContract.View mView;
    SimNetManager mSimnetManager;

    public SimPresenter() {
        mSimnetManager = Injections.provideSimNetManager();
    }

    private SimNetManager.OnSimNetChangeListener mListener = new SimNetManager.OnSimNetChangeListener() {
        @Override
        public void onChange(int status) {
            switch (status) {
                case STATE_CHECKING:
                    if (mView != null) {
                        mView.showNetChecking();
                    }
                    break;
                case STATE_HAVE_SIM:
                    if (mView != null) {
                        mView.showSimDone();
                    }
                    break;
                case STATE_NET_ERROR:
                    if (mView != null) {
                        mView.showNetError();
                    }
                    break;
                case STATE_NET_WELL:
                    if (mView != null) {
                        mView.showNetWell();
                    }
                    break;
                case STATE_NO_SIM:
                    if (mView != null) {
                        mView.showNoSim();
                    }
                    break;
            }
        }
    };

    @Override
    public void onAttachView(SimContract.View view) {
        mView = view;

        mSimnetManager.registerListener(mListener);
        mSimnetManager.requestState();
    }

    @Override
    public void onDetachView() {
        mView = null;
        mSimnetManager.unRegisterListener(mListener);
    }

    @Override
    public void next() {
//        OnNextObservable.GLOBAL_OBSERVABLE.notifyOnNext();
    }
}