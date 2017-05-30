package com.txznet.account.base.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.txznet.account.base.OnNextObservable;
import com.txznet.account.base.R;
import com.txznet.account.base.ui.fragment.BluetoothFragment;
import com.txznet.account.base.ui.fragment.FmFragment;
import com.txznet.account.base.ui.fragment.GuideFragment;
import com.txznet.account.base.ui.fragment.WakeupFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class BaseActivity extends FragmentActivity implements OnNextObservable.OnNextObserver {
    private static final String TAG = BaseActivity.class.getSimpleName();

    protected int mCurrentIndex = 0;
    protected String[] mAllFragments;
    protected Fragment mCurrentFragment;
    protected FragmentManager mFragmentManager;

    private volatile boolean exit = false;
    protected Handler mHandler = new Handler();
    private ArrayList<Integer> mIndexs = new ArrayList<>();

    private final Runnable resetExit = new Runnable() {
        @Override
        public void run() {
            exit = false;
        }
    };

    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBefore();
        setContentView(getLayoutId());
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchIndex(0);
            }
        }, 200);
    }

    protected void initBefore() {
        OnNextObservable.GLOBAL_OBSERVABLE.registerObserver(this);
        mFragmentManager = getSupportFragmentManager();
        mAllFragments = getAllFragments();
        mCurrentIndex = 0;
    }

    private int getLayoutId() {
        return R.layout.default_main_ly;
    }

    public String[] getAllFragments() {
        return new String[]{
                BluetoothFragment.class.getName(),
                FmFragment.class.getName(),
                WakeupFragment.class.getName(),
                GuideFragment.class.getName()
        };
    }

    /**
     * 添加index界面到后退栈
     *
     * @param index
     */
    public void addBackFragmentStack(int index) {
        synchronized (mIndexs) {
            mIndexs.add(index);
        }
    }

    @Override
    public void onNext() {
        if (mAllFragments == null || mAllFragments.length < 0) {
            throw new NullPointerException("allFragments is empty！");
        }

        if (mAllFragments.length - 1 == mCurrentIndex) {
            // TODO 达到最后一个
            return;
        }

        addBackFragmentStack(mCurrentIndex++);
        switchIndex(mCurrentIndex);
    }

    @Override
    public void onBackPressed() {
        synchronized (mIndexs) {
            if (mIndexs.size() > 0) {
                int index = mIndexs.remove(mIndexs.size() - 1);
                switchIndex(index);
                return;
            }
        }

        if (!exit) {
            exit = true;
            Toast.makeText(BaseActivity.this, "再按一次退出程序", Toast.LENGTH_LONG).show();
            mHandler.postDelayed(resetExit, 2000);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onEnd() {
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeAllFragment();
    }

    /**
     * 清空FragmentManager中的fragment
     */
    private void removeAllFragment() {
        List<Fragment> fragments = mFragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                mFragmentManager.beginTransaction().remove(fragment).commit();
            }
        }
    }

    /**
     * 切换为index的界面
     *
     * @param index
     */
    protected void switchIndex(int index) {
        String fragmentName = mAllFragments[index];
        if (TextUtils.isEmpty(fragmentName)) {
            throw new NullPointerException("index:" + index + " fragment is null！");
        }

        Fragment fragment = mFragmentManager.findFragmentByTag(fragmentName);
        if (fragment != null) {
            if (fragment == mCurrentFragment) {
                return;
            }
            mFragmentManager.beginTransaction().show(fragment).commit();
        } else {
            fragment = Fragment.instantiate(this, fragmentName);
            mFragmentManager.beginTransaction().add(R.id.content, fragment, fragmentName).commit();
        }
        if (mCurrentFragment != null) {
            mFragmentManager.beginTransaction().hide(mCurrentFragment).commit();
        }

        mCurrentIndex = index;
        mCurrentFragment = fragment;
    }
}