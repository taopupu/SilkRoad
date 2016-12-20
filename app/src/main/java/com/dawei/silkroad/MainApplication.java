package com.dawei.silkroad;

import android.app.Activity;
import android.app.Application;

import com.dawei.silkroad.http.HttpImple;
import com.dawei.silkroad.http.IHttp;

import java.util.LinkedList;
import java.util.List;

public class MainApplication extends Application {

    public static MainApplication application;
    private List<Activity> list = new LinkedList<>();
    public static IHttp http;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        http = new HttpImple();
    }

    public void addActivity(Activity activity) {
        list.add(activity);
    }


    public void exit() {
        try {
            for (Activity activity : list) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}

