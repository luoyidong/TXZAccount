package com.txznet.account.base.ui;

import android.widget.ImageView;
import android.widget.TextView;

import com.txznet.account.base.BaseFragment;
import com.txznet.account.base.OnNextObservable;
import com.txznet.account.base.R;
import com.txznet.account.base.mv.contract.SimContract;
import com.txznet.account.base.mv.presenter.SimPresenter;

import butterknife.BindView;

/**
 * Created by TXZ-METEORLUO on 2017/5/18.
 */
public class SimCheckFragment extends BaseFragment<SimContract.Presenter> implements SimContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.default_sim_ly;
    }

    @Override
    public SimContract.Presenter createPresenter() {
        return new SimPresenter();
    }

    @Override
    public void showNoSim() {
        findViewById(R.id.sim_status_bg).setBackgroundResource(R.drawable.icon_sim);
        ((ImageView) findViewById(R.id.sim_status)).setImageResource(R.drawable.icon_no_sim);
        ((TextView) findViewById(R.id.sim_txt)).setText(getString(R.string.string_no_sim));
    }

    @Override
    public void showSimDone() {
        findViewById(R.id.sim_status_bg).setBackgroundResource(R.drawable.icon_sim);
        ((ImageView) findViewById(R.id.sim_status)).setImageResource(R.drawable.icon_done);
        ((TextView) findViewById(R.id.sim_txt)).setText(getString(R.string.string_sim_done));
    }

    @Override
    public void showNetChecking() {
        findViewById(R.id.sim_status_bg).setBackgroundResource(R.drawable.icon_net);
        ((ImageView) findViewById(R.id.sim_status)).setImageResource(R.drawable.icon_search);
        ((TextView) findViewById(R.id.sim_txt)).setText(getString(R.string.string_net_check));
    }

    @Override
    public void showNetWell() {
        findViewById(R.id.sim_status_bg).setBackgroundResource(R.drawable.icon_net);
        ((ImageView) findViewById(R.id.sim_status)).setImageResource(R.drawable.icon_done);
        ((TextView) findViewById(R.id.sim_txt)).setText(getString(R.string.string_net_well));
    }

    @Override
    public void showNetError() {
        findViewById(R.id.sim_status_bg).setBackgroundResource(R.drawable.icon_net);
        ((ImageView) findViewById(R.id.sim_status)).setImageResource(R.drawable.icon_warn);
        ((TextView) findViewById(R.id.sim_txt)).setText(getString(R.string.string_net_error));
    }
}
