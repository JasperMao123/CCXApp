package com.example.jasper.ccxapp.ui;


import android.app.Application;
import android.content.Context;


import cn.bmob.v3.Bmob;
import cn.jpush.im.android.api.JMessageClient;


/**
 * Created by Jasper on 2017/3/21.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "31f4f13611f6d6904ee94ab4ff3095aa");//初始化Bmob

        // You can enable debug mode in developing state. You should close debug mode when release.
        JMessageClient.setDebugMode(true);
        JMessageClient.init(this,true);

        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
