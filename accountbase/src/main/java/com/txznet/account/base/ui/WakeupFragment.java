package com.txznet.account.base.ui;

import android.os.Bundle;
import android.view.View;

import com.txznet.account.base.BaseFragment;
import com.txznet.account.base.R;
import com.txznet.account.base.mv.contract.WakeupContract;
import com.txznet.account.base.mv.presenter.WakeupPresenter;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class WakeupFragment extends BaseFragment<WakeupPresenter> implements WakeupContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.default_wp_ly;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        view.findViewById(R.id.jump_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPresenter != null) {
                    mPresenter.next();
                }
            }
        });
    }

    @Override
    public WakeupPresenter createPresenter() {
        return new WakeupPresenter();
    }
}
