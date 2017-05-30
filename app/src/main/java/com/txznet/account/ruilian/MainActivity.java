package com.txznet.account.ruilian;

import com.txznet.account.base.ui.BaseActivity;

public class MainActivity extends BaseActivity {

    /**
     * 跳转界面，根据数组中的顺序切换到下一个界面
     *
     * @return
     */
    @Override
    public String[] getAllFragments() {
        return super.getAllFragments();
    }

    /**
     * 点击每个界面中的跳转实现界面切换，默认根据数组顺序向下切换
     */
    @Override
    public void onNext() {
        super.onNext();
    }

    /**
     * 结束当前引导，默认为点击免责声明界面的开启旅程后回调
     */
    @Override
    public void onEnd() {
        super.onEnd();
    }
}