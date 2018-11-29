package com.onexzgj.onexproject;

import android.widget.TextView;
import android.widget.Toast;

import com.onexzgj.onexlibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_show)
    TextView tvShow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.tv_show)
    public void onViewClicked() {
        Toast.makeText(this, "tvShow", Toast.LENGTH_SHORT).show();
    }
}
