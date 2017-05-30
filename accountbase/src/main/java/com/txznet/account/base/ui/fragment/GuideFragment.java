package com.txznet.account.base.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.txznet.account.base.R;
import com.txznet.account.base.mv.contract.GuideContract;
import com.txznet.account.base.mv.presenter.GuidePresenter;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class GuideFragment extends BaseFragment<GuideContract.Presenter> implements GuideContract.View, View.OnClickListener {

    private View mStartTv;

    @Override
    public int getLayoutId() {
        return R.layout.default_guide_ly;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mStartTv = findViewById(R.id.start_trav);

        mStartTv.setOnClickListener(this);
    }

    @Override
    public GuideContract.Presenter createPresenter() {
        return new GuidePresenter();
    }

    @Override
    public void showDisclaimer(String url) {
        WebView webView = ((WebView) findViewById(R.id.webView));
        webView.loadUrl(url);
    }

    @Override
    public void onClick(View v) {
        if (v == mStartTv) {
            if (mPresenter != null) {
                mPresenter.next();
            }
        }
    }
}