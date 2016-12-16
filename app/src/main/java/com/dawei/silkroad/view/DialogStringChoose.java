package com.dawei.silkroad.view;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.dawei.silkroad.R;
import com.dawei.silkroad.util.Logs;
import com.dawei.silkroad.util.StringUtils;
import com.dawei.silkroad.view.loopView.LoopView;
import com.dawei.silkroad.view.loopView.OnItemSelectedListener;

import java.util.List;
import java.util.Map;


/**
 * Created by zhangdesheng on 2016/4/19.
 */
public class DialogStringChoose extends AlertDialog{

    private LayoutInflater mInflater;

    private LoopView loopView;
    private OnDataChooseListener onDataChooseListener;

    private List<String>  Strings;

    public DialogStringChoose(Context context) {
        super(context, R.style.BottomDialog);
        Logs.e("dialog", "themeResId");
    }

    public DialogStringChoose(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        Logs.e("dialog", "themeResId");
    }

    public DialogStringChoose(Context context, int themeResId) {
        super(context, R.style.BottomDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_string_choose);
        gsetDecor();
        initView();
        setListener();
        Logs.e("dialog", "onCreate");
    }

    private void initView() {
        loopView = (LoopView) findViewById(R.id.loopview);

        if (Strings != null) loopView.setItems(Strings);
        if (Strings != null) loopView.setInitPosition(currentPosion);
    }

    public void setOnDataChooseListener(OnDataChooseListener onDataChooseListener){
        this.onDataChooseListener = onDataChooseListener;
    }

    private void gsetDecor(){
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.mystyle);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }

    int currentPosion;
    String item = "";
    private void setListener() {
        findViewById(R.id.dialog_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
        findViewById(R.id.dialog_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Strings != null  && Strings.size() != 0)
                onDataChooseListener.OnDataChoose(Strings.get(currentPosion));
                cancel();
            }
        });

        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (index == -1) index = Strings.size()-1;
                if (Strings != null) currentPosion = index;
            }
        });
    }

    /**  */
    public void setInitData(List<String>  Strings){
       this.Strings = Strings;
        if (Strings != null && !StringUtils.isEmpty(item)){
            if (Strings.indexOf(item) != -1)  currentPosion = Strings.indexOf(item);
        }

    }

    public void setItemData(String data){
        item = data;
        if (Strings != null && !StringUtils.isEmpty(item)){
            if (Strings.indexOf(data) != -1)  currentPosion = Strings.indexOf(data);
        }
    }

    public interface OnDataChooseListener{
        public void OnDataChoose(String date);
    }
}
