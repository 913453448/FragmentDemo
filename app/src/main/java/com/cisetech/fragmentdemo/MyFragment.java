package com.cisetech.fragmentdemo;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author EX_YINQINGYANG
 * @version [Android PABank C01, @2016-09-21]
 * @date 2016-09-21
 * @description
 */
public class MyFragment extends BaseFragment {
    /**
     * 初始化View完毕的标记
     */
    private boolean isPrepared;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView view=new TextView(getActivity());
        view.setGravity(Gravity.CENTER);
        view.setTextColor(Color.BLACK);
        view.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18f);
        isPrepared=true;
        lazyLoad();
        return view;
    }
    private ProgressDialog dialog;
    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisible) {
            return;
        }
        dialog=ProgressDialog.show(getActivity(),"","加载中，请稍后...");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(),"加载完毕！",Toast.LENGTH_SHORT).show();
                ((TextView)getView()).setText(""+getArguments().getInt("PAGE_NO"));
                dialog.dismiss();
            }
        },3000);
        //填充各控件的数据
    }

    public static Fragment newInstance(int i) {
        MyFragment fragment=new MyFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("PAGE_NO",i);
        fragment.setArguments(bundle);
        return fragment;
    }
}