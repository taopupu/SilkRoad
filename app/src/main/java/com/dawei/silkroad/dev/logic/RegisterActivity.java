package com.dawei.silkroad.dev.logic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.view.WHawkTimerBtn;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText editText,et_code,et_pwd1,et_pwd2;
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
                hawkTimerBtn.startDown();
                break;
            case R.id.btn_register:
                break;
            case R.id.title_back:
                onBackPressed();
                break;
        }
    }
}
