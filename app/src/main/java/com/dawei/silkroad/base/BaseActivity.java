package com.dawei.silkroad.base;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.dawei.silkroad.util.LoadProgress;
import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.util.SystemBarTintManager;

public class BaseActivity extends FragmentActivity {
    public LoadProgress progress;
    public MainApplication app;
    private static Boolean isExit = false;
    public static int screenWidth = 480;
    public static int screenHeight = 800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (MainApplication) this.getApplication();
        getWindowWH();
        progress = LoadProgress.createDialog(this);
        MainApplication.application.addActivity(this);
        setSystemBarColor(getResources().getColor(R.color.colorMain));
    }

    public <T extends View> T get(int id) {
        return (T) findViewById(id);
    }

    public void onBack(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public void intentActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    public void intentActivity(Class<?> cls, Intent intent) {
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public void getWindowWH() {
        Display mDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics metric = new DisplayMetrics();
        mDisplay.getMetrics(metric);
        screenWidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        screenHeight = getWindow().getWindowManager().getDefaultDisplay().getHeight();
    }

    @Override
    protected void onDestroy() {
        if (progress != null && progress.isShowing()) {
            progress.hide();
            progress.dismiss();
        }
        super.onDestroy();
    }

    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if (progress != null && progress.isShowing()) {
            progress.hide();
            progress.dismiss();
        }
    }

    /**
     * 设置状态栏颜色
     */
    public void setSystemBarColor(@ColorInt int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager mTintManager;
            mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);
            mTintManager.setNavigationBarTintEnabled(false);
            mTintManager.setTintColor(color);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                        | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(color);
            } catch (IllegalArgumentException ignore) {
                Log.e("BaseActivity", "Invalid hexString argument, use f.i. '#999999'");
            } catch (Exception ignore) {
                Log.w("BaseActivity", "Method window.setStatusBarColor not found for SDK level " + Build.VERSION.SDK_INT);
            }
        }
    }
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            exitByDoubleClick();
//        }
//        return false;
//    }
//
//
//    private void exitByDoubleClick() {
//        Timer tExit = null;
//        if (isExit == false) {
//            isExit = true;
//            toast("再按一次退出程序");
//            tExit = new Timer();
//            tExit.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    isExit = false;
//                }
//            }, 2000);
//
//        } else {
//            finish();
//        }
//    }
}
