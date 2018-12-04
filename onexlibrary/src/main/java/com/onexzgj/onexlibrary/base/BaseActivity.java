package com.onexzgj.onexlibrary.base;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.blankj.utilcode.util.BarUtils;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 全局application
     */
    public Application mApplication;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getLayoutId()>0){
            setContentView(getLayoutId());
            ButterKnife.bind(this);
        }


        BarUtils.hideNotificationBar(this);
        BarUtils.hideNavBar(this);
        //初始化
        initView();
        initData();

    }

    /**
     * 初始化Toolbar
     */
    private void initToolBar(int toolBarId) {
        mToolbar = (Toolbar) findViewById(toolBarId);
        if (mToolbar == null) {
            throw new NullPointerException("toolbar can not be null");
        }
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeAsUp());
        /**toolbar除掉阴影*/
        getSupportActionBar().setElevation(0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(0);
        }
    }

    /**
     * 是否显示返回键
     *
     * @return
     */
    protected boolean showHomeAsUp() {
        return false;
    }

    protected abstract int getLayoutId();


    protected abstract void initView();


    protected abstract void initData();


    /** 跳转指定的activity */
    public void startActivity( Class<? extends Activity> cls){
        startActivity(new Intent(this,cls));
    }




}
