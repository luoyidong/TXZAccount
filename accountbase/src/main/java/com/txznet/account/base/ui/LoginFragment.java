package com.txznet.account.base.ui;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.txznet.account.base.BaseFragment;
import com.txznet.account.base.R;
import com.txznet.account.base.mv.contract.LoginContract;
import com.txznet.account.base.mv.presenter.LoginPresenter;

import butterknife.BindView;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class LoginFragment extends BaseFragment<LoginContract.Presenter> implements LoginContract.View, View.OnClickListener {

    EditText mPhoneEt;
    LinearLayout mPhoneLy;

    LinearLayout mCodeLy;
    EditText mCodeEt;
    TextView mCodeTv;
    TextView mLoginTv;
    TextView mSmTv;

    @Override
    public int getLayoutId() {
        return R.layout.default_login_ly;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPhoneEt = (EditText) findViewById(R.id.phone_et);
        mPhoneLy = (LinearLayout) findViewById(R.id.iphone_ly);
        mCodeLy = (LinearLayout) findViewById(R.id.code_ly);
        mCodeEt = (EditText) findViewById(R.id.idcode_et);
        mCodeTv = (TextView) findViewById(R.id.getCode_tv);
        mLoginTv = (TextView) findViewById(R.id.login_tv);
        mSmTv = (TextView) findViewById(R.id.saomao_tv);

        mCodeTv.setOnClickListener(this);
        mLoginTv.setOnClickListener(this);
    }

    @Override
    public LoginContract.Presenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void showPhoneError() {
        mPhoneEt.requestFocus();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mPhoneEt.setTextColor(getResources().getColor(R.color.color_error_input, null));
        } else {
            mPhoneEt.setTextColor(getResources().getColor(R.color.color_error_input));
        }

        showToast(getString(R.string.string_input_correct_phone));
    }

    @Override
    public void showIdCodeError() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mCodeEt.setTextColor(getResources().getColor(R.color.color_error_input, null));
        } else {
            mCodeEt.setTextColor(getResources().getColor(R.color.color_error_input));
        }

        showToast(getString(R.string.string_input_correct_code));
    }

    private void clearPhoneError() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mPhoneEt.setTextColor(getResources().getColor(R.color.color_text_main, null));
        } else {
            mPhoneEt.setTextColor(getResources().getColor(R.color.color_text_main));
        }
    }

    private void clearIdCodeError() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mCodeEt.setTextColor(getResources().getColor(R.color.color_text_main, null));
        } else {
            mCodeEt.setTextColor(getResources().getColor(R.color.color_text_main));
        }
    }

    private void clearAllError() {
        clearPhoneError();
        clearIdCodeError();
    }

    @Override
    public void showToast(String txt) {
        Toast.makeText(getContext(), txt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void inputCode(String code) {
        mCodeEt.setText(code);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginTv) {
            checkToLogin();
        } else if (v == mCodeTv) {
            checkToGetIdCode();
        }
    }


    private void checkToLogin() {
        // TODO 登录检测
        String phone = mPhoneEt.getText().toString();
        if (TextUtils.isEmpty(phone) || !isMobile(phone)) {
            showPhoneError();
            return;
        }

        String idCode = mCodeEt.getText().toString();
        if (TextUtils.isEmpty(idCode)) {
            showIdCodeError();
            return;
        }

        clearAllError();
        if (mPresenter != null) {
            mPresenter.doLogin(phone, idCode);
        }
    }

    private void checkToGetIdCode() {
        // TODO 获取验证码
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobile(String number) {
        /* 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通） 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9 */
        String num = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }
    }
}