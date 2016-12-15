package com.dawei.silkroad.dev.logic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dawei.silkroad.R;
import com.dawei.silkroad.base.BaseActivity;
import com.dawei.silkroad.dev.WHawkTimerBtn;

public class ChangePwdActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_title;
    private ImageView img_back;
    private EditText valide;
    private WHawkTimerBtn sendValide;
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
        valide = get(R.id.valide);
        et_pwd1 = get(R.id.et_pwd1);
        et_pwd2 = get(R.id.et_pwd2);
        sendValide = get(R.id.sendValide);
        btn_sure = get(R.id.btn_sure);
        sendValide.setOnClickListener(this);
        btn_sure.setOnClickListener(this);
        img_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sendValide:
                break;
            case R.id.btn_sure:
                break;
            case R.id.title_back:
                onBackPressed();
                break;
        }
    }
}
