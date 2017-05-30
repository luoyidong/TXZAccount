package com.txznet.account.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.txznet.account.base.ui.BluetoothFragment;
import com.txznet.account.base.ui.FmFragment;
import com.txznet.account.base.ui.GuideFragment;
import com.txznet.account.base.ui.LoginFragment;
import com.txznet.account.base.ui.SimCheckFragment;
import com.txznet.account.base.ui.WakeupFragment;

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

    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "activity onCreate");
        initBefore();

        setContentView(getLayoutId());

        switchIndex(0);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "activity onNewIntent");
    }

    protected void initBefore() {
        OnNextObservable.GLOBAL_OBSERVABLE.registerObserver(this);

        mFragmentManager = getSupportFragmentManager();
        mAllFragments = getAllFragments();

        mCurrentIndex = 0;
    }

    public int getLayoutId() {
        return R.layout.default_main_ly;
    }

    public String[] getAllFragments() {
        return new String[]{
                BluetoothFragment.class.getName(),
                FmFragment.class.getName(),
//                LoginFragment.class.getName(),,
//                SimCheckFragment.class.getName(),
                WakeupFragment.class.getName(),
                GuideFragment.class.getName()
        };
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

        mCurrentIndex++;
        switchIndex(mCurrentIndex);
    }

    long mLastPressTime;

    @Override
    public void onBackPressed() {
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

    private void removeAllFragment() {
        List<Fragment> fragments = mFragmentManager.getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                mFragmentManager.beginTransaction().remove(fragment).commit();
            }
        }
    }

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