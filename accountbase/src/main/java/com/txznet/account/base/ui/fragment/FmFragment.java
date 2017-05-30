package com.txznet.account.base.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.txznet.account.base.R;
import com.txznet.account.base.mv.contract.FmContract;
import com.txznet.account.base.mv.presenter.FmPresenter;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class FmFragment extends BaseFragment<FmPresenter> implements FmContract.View, View.OnClickListener {

    private View mJumpBtn;
    private View mOpenBtn;

    private View mDecBtn;
    private View mIncBtn;

    @Override
    public int getLayoutId() {
        return R.layout.default_fm_ly;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mJumpBtn = findViewById(R.id.jump_btn);
        mOpenBtn = findViewById(R.id.open_btn);

        mDecBtn = findViewById(R.id.dec_btn);
        mIncBtn = findViewById(R.id.inc_btn);

        mJumpBtn.setOnClickListener(this);
        mOpenBtn.setOnClickListener(this);

        mDecBtn.setOnClickListener(this);
        mIncBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mJumpBtn) {
            if (mPresenter != null) {
                mPresenter.next();
            }
        } else if (v == mOpenBtn) {

        } else if (v == mDecBtn) {

        } else if (v == mIncBtn) {

        }
    }

    @Override
    public FmPresenter createPresenter() {
        return new FmPresenter();
    }
}
