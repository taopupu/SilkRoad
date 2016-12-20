package com.dawei.silkroad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.callback.UserCallBack;
import com.dawei.silkroad.dev.HomePagerActivity;
import com.dawei.silkroad.http.HttpImple;
import com.dawei.silkroad.http.IHttp;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout pointGroup;
    private int lastPosition;
    private ImageView iv_start,welcome;
    private ViewPager viewPager;
    private final int[] imageIds = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private static final int ANIMATION_DURATION = 3000;
    private static final float SCALE_END = 1.08F;
    private SharedPreferences sp;
    private Boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();
    }

    private void initView() {
        pointGroup = get(R.id.point_group);
        iv_start = get(R.id.start);
        viewPager = get(R.id.viewpager);
        welcome = get(R.id.welcome);
        iv_start.setOnClickListener(this);
        animateImage();
    }

    private void init() {
        sp = this.getSharedPreferences("save", Context.MODE_PRIVATE);
        status = sp.getBoolean("welcome", false);
    }

    private void animateImage() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(welcome, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(welcome, "scaleY", 1f, SCALE_END);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        set.start();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("welcome", true);
                editor.commit();
                if (status) {
                    intentActivity(HomePagerActivity.class);
                    finish();
                } else {
                    initWithPageGuideMode();
                }
            }
        });
    }

    private void initWithPageGuideMode() {
        List<View> mList = new ArrayList<View>();
        int i = 0;
        LinearLayout.LayoutParams ivParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        for (int index : imageIds) {
            ImageView item = new ImageView(this);
            item.setScaleType(ImageView.ScaleType.CENTER_CROP);
            item.setLayoutParams(ivParam);

            item.setImageResource(index);
            mList.add(item);

            //添加指示点
            ImageView point = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.rightMargin = 20;
            point.setLayoutParams(params);

            if (i == 0) {
                point.setBackgroundResource(R.mipmap.p0_point_b);
            } else {
                point.setBackgroundResource(R.mipmap.p0_point_a);
            }
            pointGroup.addView(point);
            i++;
        }

        MyPagerAdapter adapter = new MyPagerAdapter(mList);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                intentActivity(HomePagerActivity.class);
                finish();
                break;
        }
    }

    private class MyPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

        private List<View> mViewList;

        public MyPagerAdapter(List<View> views) {
            mViewList = views;
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position), 0);
            return mViewList.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            if (view == object) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            System.out.println("destroyItem  ::" + position);
            container.removeView(mViewList.get(position));
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int position) {

            if (position == mViewList.size() - 1) {
                iv_start.setVisibility(View.VISIBLE);
            } else {
                iv_start.setVisibility(View.GONE);
            }
            pointGroup.getChildAt(position).setBackgroundResource(R.mipmap.p0_point_b);
            pointGroup.getChildAt(lastPosition).setBackgroundResource(R.mipmap.p0_point_a);
            lastPosition = position;
        }
    }
}
