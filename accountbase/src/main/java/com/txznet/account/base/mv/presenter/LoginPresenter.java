package com.txznet.account.base.mv.presenter;

import android.text.TextUtils;

import com.txznet.account.base.BaseContract;
import com.txznet.account.base.module.Injections;
import com.txznet.account.base.module.LoginManager;
import com.txznet.account.base.mv.contract.LoginContract;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class LoginPresenter implements LoginContract.Presenter {
    LoginManager mLoginManager;
    LoginContract.View mView;

    public LoginPresenter() {
        mLoginManager = Injections.provideLoginManager();
    }

    @Override
    public void doLogin(String phone, String code) {
        mLoginManager.login(phone, code);
    }

    @Override
    public void getIdCodeByPhone(String phone) {
        String code = mLoginManager.getIdCode(phone);
        if (!TextUtils.isEmpty(code)) {
            if (mView != null) {
                mView.inputCode(code);
            }
        }
    }

    @Override
    public void onAttachView(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void onDetachView() {
        mView = null;
    }

    @Override
    public void next() {
    }
}
