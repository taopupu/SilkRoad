package com.dawei.silkroad;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.dawei.silkroad.http.HttpImple;
import com.dawei.silkroad.http.IHttp;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.LinkedList;
import java.util.List;

public class MainApplication extends Application {

    public static MainApplication application;
    private List<Activity> list = new LinkedList<>();
    public static IHttp http;
    public static DisplayImageOptions baseImageOptions;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        http = new HttpImple();
        initImageLoader(this);
        initImageOptions();
    }

    public void addActivity(Activity activity) {
        list.add(activity);
    }
    private void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.threadPoolSize(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }
    private void initImageOptions(){
        baseImageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(0))
                .build();
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

