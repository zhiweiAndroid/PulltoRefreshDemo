package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.R;


/**
 * Created by win7 on 2017/4/18.
 */

public class TweenAnimLoadingLayout extends LoadingLayout {
    private AnimationDrawable animationDrawable;
    public TweenAnimLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);
        mHeaderImage.setImageResource(R.drawable.arrow);
       //animationDrawable = (AnimationDrawable) mHeaderImage.getDrawable();
    }

    @Override
    protected int getDefaultDrawableResId() {
        return R.drawable.arrow;
    }

    @Override
    protected void onLoadingDrawableSet(Drawable imageDrawable) {

    }

    @Override
    protected void onPullImpl(float scaleOfLayout) {

    }

    @Override
    protected void pullToRefreshImpl() {

    }

    @Override
    protected void refreshingImpl() {
        // 播放帧动画
      //  animationDrawable.start();
    }

    @Override
    protected void releaseToRefreshImpl() {

    }

    @Override
    protected void resetImpl() {
        mHeaderImage.setVisibility(View.VISIBLE);
        mHeaderImage.clearAnimation();
    }

    @Override
    public void setLastUpdatedLabel(CharSequence label) {

    }
}
