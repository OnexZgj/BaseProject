package com.onexzgj.onexproject.activity;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.BarUtils;
import com.onexzgj.onexlibrary.base.BaseActivity;
import com.onexzgj.onexproject.R;

import butterknife.BindView;

/**
 * 闪屏页面
 */
public class SplashActivity extends BaseActivity implements Animation.AnimationListener {


    private static final int ANIM_TIME = 1000;

    @BindView(R.id.tv_as_show)
    TextView tvAsShow;
    @BindView(R.id.iv_as_bg)
    ImageView ivAsBg;
    @BindView(R.id.iv_as_icon)
    ImageView ivAsIcon;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    protected void initView() {
        BarUtils.setStatusBarAlpha(this,0);
        initStartAnim();
//        //设置状态栏和导航栏参数
//        getStatusBarConfig()
//                .fullScreen(true)//有导航栏的情况下，activity全屏显示，也就是activity最下面被导航栏覆盖，不写默认非全屏
//                .hideBar(BarHide.FLAG_HIDE_STATUS_BAR)//隐藏状态栏
//                .transparentNavigationBar()//透明导航栏，不写默认黑色(设置此方法，fullScreen()方法自动为true)
//                .init();



    }


    /**
     * 启动动画
     */
    private void initStartAnim() {
        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.4f, 1.0f);
        aa.setDuration(ANIM_TIME * 2);
        aa.setAnimationListener(this);
        ivAsBg.startAnimation(aa);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(ANIM_TIME);
        ivAsIcon.startAnimation(sa);

        RotateAnimation ra = new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(ANIM_TIME);
        tvAsShow.startAnimation(ra);
    }


    @Override
    protected void initData() {

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
