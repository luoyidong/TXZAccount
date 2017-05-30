package com.txznet.account.base.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.txznet.account.base.BaseFragment;
import com.txznet.account.base.R;
import com.txznet.account.base.mv.contract.BluetoothContract;
import com.txznet.account.base.mv.presenter.BluetoothPresenter;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class BluetoothFragment extends BaseFragment<BluetoothPresenter> implements BluetoothContract.View {

    private View mJumpView;

    @Override
    public int getLayoutId() {
        return R.layout.default_conn_bt_ly;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mJumpView = findViewById(R.id.jump_btn);

        mJumpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPresenter != null) {
                    mPresenter.next();
                }
            }
        });
    }

    @Override
    public BluetoothPresenter createPresenter() {
        return new BluetoothPresenter();
    }

    @Override
    public void showConnecting() {
        ((TextView) findViewById(R.id.link_tv)).setText(getString(R.string.string_bt_wait));
        ((ImageView) findViewById(R.id.link_mark_iv)).setImageResource(R.drawable.icon_error);
        startAnimator();
    }

    private void startAnimator() {
    }

    private void clearAnimator() {

    }

    @Override
    public void showConnected() {
        ((TextView) findViewById(R.id.link_tv)).setText(getString(R.string.string_bt_connect));
        ((ImageView) findViewById(R.id.link_mark_iv)).setImageResource(R.drawable.icon_done);
        clearAnimator();
    }

    @Override
    public void showDeviceName(String name) {
    }

    @Override
    public void showPhoneName(String name) {

    }
}