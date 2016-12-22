package com.dawei.silkroad.dev.user.bean;


import android.content.Context;

import com.dawei.silkroad.util.PreferencesUtil;

public class User {
    public Context context;
    public int id;
    public String account;
    public String password;
    public Boolean flag;

    public User(Context context) {
        this.context = context;
    }

    public void save() {
        PreferencesUtil.save(this, context);
    }
    public void load(){
        PreferencesUtil.loadData(this, context);
    }
}
