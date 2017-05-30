package com.txznet.account.base.mv.contract;

import com.txznet.account.base.BaseContract;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public interface GuideContract {

    interface View extends BaseContract.View {

        void showDisclaimer(String url);

    }

    interface Presenter extends BaseContract.Presenter<View> {

    }
}
