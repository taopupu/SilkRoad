package com.dawei.silkroad.dev.logic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.dawei.silkroad.http.HttpImple;
import com.dawei.silkroad.http.IHttp;
import com.dawei.silkroad.util.StringUtils;
import com.dawei.silkroad.view.WHawkTimerBtn;

import okhttp3.Call;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText editText, et_code, et_pwd1, et_pwd2;
    private WHawkTimerBtn hawkTimerBtn;
    private Button btn_register;
    private Boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        flag = getIntent().getBooleanExtra("flag", true);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        editText = get(R.id.valide);
        et_code = get(R.id.et_code);
        et_pwd1 = get(R.id.et_pwd1);
        et_pwd2 = get(R.id.et_pwd2);
        btn_register = get(R.id.btn_register);
        ImageView img_back = get(R.id.title_back);
        hawkTimerBtn = get(R.id.sendValide);
        hawkTimerBtn.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        img_back.setOnClickListener(this);
        if (flag) {
            tv_title.setText(getResources().getText(R.string.register));
            btn_register.setText(getResources().getText(R.string.register));
        } else {
            tv_title.setText(getResources().getText(R.string.forget_password));
            btn_register.setText(getResources().getText(R.string.sure));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sendValide:
                doLogic();
                break;
            case R.id.btn_register:
                register();
                break;
            case R.id.title_back:
                onBackPressed();
                break;
        }
    }

    String phone;

    private void doLogic() {
        phone = editText.getText().toString();
        if (StringUtils.isEmpty(phone) || !StringUtils.isPhone(phone)) {
            toast("请输入正确的手机号");
            return;
        }
        MainApplication.http.sms(phone, new HttpCallBack() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(HttpData response, int id) {

                if (response.flag) {
                    hawkTimerBtn.startDown();
                } else {
                    toast(response.info);
                }
            }
        });
    }

    private void register() {
        String code = et_code.getText().toString();
        String pwd1 = et_pwd1.getText().toString();
        String pwd2 = et_pwd2.getText().toString();
        if (!pwd1.equals(pwd2)) {
            toast("两次密码不一致");
            return;
        }
        if (StringUtils.isEmpty(phone) || !StringUtils.isPhone(phone)) {
            toast("请输入正确的手机号");
            return;
        }
        if (StringUtils.isEmpty(code)) {
            toast("请输入验证码");
            return;
        }
        MainApplication.http.register(phone, pwd1, code, new HttpCallBack() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.d("----", "not request");
            }

            @Override
            public void onResponse(HttpData response, int id) {
                toast(response.info);
                if (response.flag){
                    intentActivity(LoginActivity.class);
                    finish();
                }
            }
        });
    }


}
