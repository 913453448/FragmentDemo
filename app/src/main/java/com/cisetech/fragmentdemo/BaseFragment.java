package com.cisetech.fragmentdemo;

import android.support.v4.app.Fragment;

/**
 * Author:Yqy
 * Date:2016-09-21
 * Desc:
 * Company:cisetech
 */
public abstract class BaseFragment extends Fragment {
    /**
     * 是否对用户可见标记
     */
    protected boolean isVisible;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            isVisible = true;
            onVisible();
        }else{
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 不可见的时候操作
     */
    protected void onVisible(){
        lazyLoad();
    }

    /**
     * 抽象lazyLoad方法，让子类实现。
     */
    protected abstract void lazyLoad();
    protected void onInvisible(){}
}
