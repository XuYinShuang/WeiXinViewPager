package com.xuyinshuang.weixinviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuyinshuang.weixinviewpager.R;

/**
 * Created by Administrator on 2016/8/2.
 */
public class FragmentMy extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_my,container,false);
        return view;
    }
}
