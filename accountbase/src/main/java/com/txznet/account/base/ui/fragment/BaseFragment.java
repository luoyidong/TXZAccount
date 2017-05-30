package com.txznet.account.base.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.txznet.account.base.ui.BaseContract;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public abstract class BaseFragment<P extends BaseContract.Presenter> extends Fragment implements BaseContract.View {

    protected P mPresenter;

    protected View mContentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContentView = inflater.inflate(getLayoutId(), null);
        if (mPresenter != null) {
            mPresenter.onAttachView(this);
        }
        return mContentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.onDetachView();
        }
    }

    public View findViewById(int id) {
        return mContentView.findViewById(id);
    }

    public abstract int getLayoutId();

    public abstract P createPresenter();
}