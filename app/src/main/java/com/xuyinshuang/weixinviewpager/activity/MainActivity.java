package com.xuyinshuang.weixinviewpager.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xuyinshuang.weixinviewpager.R;
import com.xuyinshuang.weixinviewpager.adapter.MyFragmntAdapter;
import com.xuyinshuang.weixinviewpager.fragment.FragmentFind;
import com.xuyinshuang.weixinviewpager.fragment.FragmentFriend;
import com.xuyinshuang.weixinviewpager.fragment.FragmentMy;
import com.xuyinshuang.weixinviewpager.fragment.FragmentWeiXin;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private ImageView ivWeiXin, ivVisitor, ivFind, ivMy;
    private TextView txtweiXin, txtfriend, txtMy, txtFind;
    private LinearLayout layoutWeixin, layoutFriend, layoutFind, layoutMy, lineContent;
    private List<Fragment> fragmentList;//用来存放其余窗体

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ivWeiXin = (ImageView) findViewById(R.id.ivWeiXin);
        txtweiXin = (TextView) findViewById(R.id.txtweiXin);
        layoutWeixin = (LinearLayout) findViewById(R.id.layout_weixin);
        ivVisitor = (ImageView) findViewById(R.id.ivVisitor);
        txtfriend = (TextView) findViewById(R.id.txtfriend);
        layoutFriend = (LinearLayout) findViewById(R.id.layout_friend);
        ivFind = (ImageView) findViewById(R.id.ivFind);
        txtFind = (TextView) findViewById(R.id.txtFind);
        layoutFind = (LinearLayout) findViewById(R.id.layout_find);
        ivMy = (ImageView) findViewById(R.id.ivMy);
        txtMy = (TextView) findViewById(R.id.txtMy);
        layoutMy = (LinearLayout) findViewById(R.id.layout_my);
        lineContent = (LinearLayout) findViewById(R.id.line_content);


        layoutWeixin.setOnClickListener(new layoutListener(0));
        layoutFriend.setOnClickListener(new layoutListener(1));
        layoutFind.setOnClickListener(new layoutListener(2));
        layoutMy.setOnClickListener(new layoutListener(3));
    }

    //给ViewPager添加视图
    private void initViewPager() {
        fragmentList = new ArrayList<>();
        FragmentWeiXin weiXin = new FragmentWeiXin();
        FragmentFind find = new FragmentFind();
        FragmentFriend friend = new FragmentFriend();
        FragmentMy my = new FragmentMy();

        //把视图一个一个添加进去
        fragmentList.add(weiXin);
        fragmentList.add(friend);
        fragmentList.add(find);
        fragmentList.add(my);

        //绑定适配器
        MyFragmntAdapter adapter = new MyFragmntAdapter(
                getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);

        //设置当前显示的标签为第一页
        viewPager.setCurrentItem(0);


        //设置监听事件
        viewPager.setOnPageChangeListener(new MyPagerListener());
    }

    //设置默认的图片和文字颜色
    private void defaultImage() {
        ivWeiXin.setImageResource(R.drawable.message);
        ivMy.setImageResource(R.drawable.my);
        ivFind.setImageResource(R.drawable.find);
        ivVisitor.setImageResource(R.drawable.contact);

        //当前显示的文字颜色
        txtMy.setTextColor(Color.BLACK);
        txtFind.setTextColor(Color.BLACK);
        txtfriend.setTextColor(Color.BLACK);
        txtweiXin.setTextColor(Color.BLACK);

    }

    //Layout监听
    private class layoutListener implements View.OnClickListener {

        private int index = 0;

        public layoutListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            viewPager.setCurrentItem(index);
            switch (index) {
                case 0:
                    ivWeiXin.setBackgroundColor(Color.WHITE);
                    ivWeiXin.setImageResource(R.drawable.message1);
                    txtweiXin.setTextColor(Color.GREEN);
                    break;
                case 1:
                    ivVisitor.setBackgroundColor(Color.WHITE);
                    ivVisitor.setImageResource(R.drawable.contact1);
                    txtfriend.setTextColor(Color.GREEN);
                    break;
                case 2:
                    ivFind.setBackgroundColor(Color.WHITE);
                    ivFind.setImageResource(R.drawable.find1);
                    txtFind.setTextColor(Color.GREEN);
                    break;
                case 3:
                    ivMy.setBackgroundColor(Color.WHITE);
                    ivMy.setImageResource(R.drawable.my1);
                    txtMy.setTextColor(Color.GREEN);
                    break;
                default:
                    break;
            }
        }
    }

    //滑动监听
    private class MyPagerListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            defaultImage();
            switch (position) {
                case 0:
                    ivWeiXin.setBackgroundColor(Color.WHITE);
                    ivWeiXin.setImageResource(R.drawable.message1);
                    txtweiXin.setTextColor(Color.GREEN);
                    break;
                case 1:
                    ivVisitor.setBackgroundColor(Color.WHITE);
                    ivVisitor.setImageResource(R.drawable.contact1);
                    txtfriend.setTextColor(Color.GREEN);
                    break;
                case 2:
                    ivFind.setBackgroundColor(Color.WHITE);
                    ivFind.setImageResource(R.drawable.find1);
                    txtFind.setTextColor(Color.GREEN);
                    break;
                case 3:
                    ivMy.setBackgroundColor(Color.WHITE);
                    ivMy.setImageResource(R.drawable.my1);
                    txtMy.setTextColor(Color.GREEN);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
