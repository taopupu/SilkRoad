package com.dawei.silkroad;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.util.Logs;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestActivity extends BaseActivity {
    XRecyclerView recyclerView;
    DisplayImageOptions baseImageOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initImageLoader(this);
        baseImageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(0))
                .build();

        recyclerView = get(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new TestAdapter(geturl()));
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                recyclerView.loadMoreComplete();
            }
        });
    }


    List<String> geturl (){
        List<String> list = new ArrayList<>();
        list.add("http://img2.scimg.cn/userupload/auction/items/886/449768/orig/5e8fad57736feadccb605f224e228e51.jpg");
        list.add("http://pic24.nipic.com/20121024/310438_162351346110_2.jpg");
        list.add("http://img005.hc360.cn/y2/M03/D5/92/wKhQdFSNOSmEdLsAAAAAADPD-BI808.jpg");
        list.add("http://img2.scimg.cn/userupload/auction/items/4250/655905/orig/cc9e00c31ac423f4bd4a58c92c0b57ee.jpg");
        list.add("http://img2.scimg.cn/userupload/auction/items/2943/512032/orig/6f3778b7fff6e1b0ccc97a710821c0a8.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=3869282230,125610845&fm=214&gp=0.jpg");
        list.add("http://imagecdn.edeng.cn/uimages/6/46/64/152614044.gif");
        list.add("http://pic26.nipic.com/20121225/310438_133115625143_2.jpg");
        list.add("http://file5.gucn.com/file2/CurioPicfile/20130408/Gucn_2013040881940152015Pic2.jpg");
        list.add("http://s13.sinaimg.cn/mw690/001Oel7Hgy6YGhEvfK44c");
        list.add("http://s13.sinaimg.cn/mw690/4e5ada0egcfff256ad4ec&690");
        list.add("http://www.7wchina.com/upload_files/other/43827_20150212140242_qst8m.jpg");
        list.add("http://www.jzshsc.com/data/files/store_3327/goods_142/201503160905425623.jpg");
        list.add("http://pic.58pic.com/58pic/14/87/99/22s58PICQJU_1024.jpg");
        list.add("http://s7.sinaimg.cn/mw690/001J0CiIty6SOGHF89w16&690");
        return list;
    }
    private Map<Integer,Integer> mHeights = new HashMap<>();
    class TestAdapter extends RecyclerView.Adapter<Holder>{
        List<String> list ;

        public TestAdapter(List<String> list) {
            this.list = list;
            for (int i=0;i<list.size();i++){
                mHeights.put(i,0);
            }
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test,parent,false));
        }

        @Override
        public void onBindViewHolder(final Holder holder, final int position) {
//            Glide.with(TestActivity.this).load(list.get(position)).asBitmap().into(new SimpleTarget<Bitmap>() {
//                @Override
//                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
////                    holder.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//                    holder.imageView.setImageBitmap(resource);
//                }
//            });
//            Glide.with(TestActivity.this).load(list.get(position)).into(holder.imageView);

//            ImageLoader.getInstance().displayImage(list.get(position),holder.imageView);
            ImageLoader.getInstance().displayImage(list.get(position), holder.imageView, baseImageOptions, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String s, View view) {}
                @Override
                public void onLoadingFailed(String s, View view, FailReason failReason) {}

                @Override
                public void onLoadingComplete(String s, View view, Bitmap bitmap) {
                    LinearLayout.LayoutParams lp;
                    if (mHeights.get(position) < 0) {
                        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, mHeights.get(position));
                        holder.imageView.setLayoutParams(lp);
                    }else {
                        int h = (bitmap.getHeight() * BaseActivity.screenWidth / 2 -30) /bitmap.getWidth();
                        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, h);
                        holder.imageView.setLayoutParams(lp);
                        mHeights.put(position,h);
                    }
                    Logs.e("bitmap","Height:"+holder.imageView.getHeight()+" :"+position);
                    ((ImageView)view).setImageBitmap(bitmap);
                }
                @Override
                public void onLoadingCancelled(String s, View view) {}
            });
            holder.text.setText("天道酬勤"+position);
        }
        @Override
        public int getItemCount() {
            return list.size();
        }
    }
    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView text;
        View itemView;
        public Holder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }






    public static void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
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

}
