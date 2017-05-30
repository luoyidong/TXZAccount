package com.txznet.account.base.mv.contract;

import com.txznet.account.base.BaseContract;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public interface LoginContract {

    interface View extends BaseContract.View {
        void showPhoneError();

        void showIdCodeError();

        void inputCode(String code);

        void showToast(String txt);
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void doLogin(String phone, String code);

        void getIdCodeByPhone(String phone);

    }
}
