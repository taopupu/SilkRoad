package com.dawei.silkroad.dev.logic;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.HomePagerActivity;
import com.dawei.silkroad.util.StringUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    private EditText et_phone;
    private EditText et_pwd;
    private ImageView icon_close;
    private ImageView icon_eyes;
    private boolean isFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        TextView tv_title = get(R.id.tv_title);
        ImageView img_back = get(R.id.title_back);
        icon_close = get(R.id.icon_close);
        icon_eyes = get(R.id.icon_eye);
        et_phone = get(R.id.phone);
        et_pwd = get(R.id.password);
        Button btn_submit = get(R.id.submit);
        TextView tv_forgetPwd = get(R.id.forgetPwd);
        TextView tv_register = get(R.id.tv_register);
        et_phone.addTextChangedListener(this);
        tv_title.setText(getResources().getText(R.string.logic_title));
        img_back.setOnClickListener(this);
        icon_close.setOnClickListener(this);
        icon_eyes.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
        tv_forgetPwd.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                onBackPressed();
                break;
            case R.id.icon_close:
                et_phone.setText("");
                break;
            case R.id.icon_eye:
                doEye();
                break;
            case R.id.submit:
                doLogic();
                break;
            case R.id.forgetPwd:
                intentActivity(RegisterActivity.class, new Intent().putExtra("flag", false));
                break;
            case R.id.tv_register:
                intentActivity(RegisterActivity.class, new Intent().putExtra("flag", true));
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String phone = et_phone.getText().toString();
        if (StringUtil.isEmpty(phone)) {
            icon_close.setVisibility(View.GONE);
        } else {
            icon_close.setVisibility(View.VISIBLE);
        }
        if (phone.trim().length() == 11) et_pwd.requestFocus();
    }

    private void doLogic() {
        String phone = et_phone.getText().toString();
        if (StringUtil.isEmpty(phone)||!StringUtil.isPhone(phone)) {
            toast("请输入正确的手机号");
            return;
        }

        String password = et_pwd.getText().toString();
        if (StringUtil.isNotValidePwd(password)) {
            toast("密码需在6-20位之间");
            return;
        }
        intentActivity(HomePagerActivity.class);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    private void doEye() {
        if (!isFlag) {
            et_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            et_pwd.setSelection(et_pwd.getText().toString().length());
            icon_eyes.setImageResource(R.mipmap.ic_eye_click);
            isFlag = true;
        } else {
            et_pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            et_pwd.setSelection(et_pwd.getText().toString().length());
            icon_eyes.setImageResource(R.mipmap.ic_eye);
            isFlag = false;
        }
    }
}
