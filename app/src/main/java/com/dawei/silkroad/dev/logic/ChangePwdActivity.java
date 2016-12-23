package com.dawei.silkroad.dev.logic;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dawei.silkroad.MainApplication;
import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.callback.HttpCallBack;
import com.dawei.silkroad.callback.HttpData;
import com.dawei.silkroad.util.StringUtils;
import com.dawei.silkroad.view.WHawkTimerBtn;

import okhttp3.Call;

public class ChangePwdActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_title;
    private ImageView img_back;
    private EditText oldPwd;
    private EditText et_pwd1;
    private EditText et_pwd2;
    private Button btn_sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        initView();
    }

    private void initView() {
        tv_title = get(R.id.tv_title);
        img_back = get(R.id.title_back);
        et_pwd1 = get(R.id.et_pwd1);
        et_pwd2 = get(R.id.et_pwd2);
        oldPwd = get(R.id.old_pwd);
        btn_sure = get(R.id.btn_sure);
        btn_sure.setOnClickListener(this);
        img_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sure:
                changePwd();
                break;
            case R.id.title_back:
                onBackPressed();
                break;
        }
    }

    private void changePwd() {
        String old_pwd = oldPwd.getText().toString();
        String pwd1 = et_pwd1.getText().toString();
        String pwd2 = et_pwd2.getText().toString();
        if (StringUtils.isEmpty(old_pwd)) {
            toast("请输入旧密码");
            return;
        }
        if (StringUtils.isEmpty(pwd1)) {
            toast("请输入新密码");
            return;
        }
        if (StringUtils.isEmpty(pwd2)) {
            toast("请确认密码");
            return;
        }
        MainApplication.http.changePwd(user.id, old_pwd, pwd1, pwd2, new HttpCallBack() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(HttpData response, int id) {
                if (response.flag) {
                    finish();
                }
            }
        });
    }
}
