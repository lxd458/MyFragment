package com.example.activity2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/* 创建一个 静态的广播接收器类 MyReceiver
  必须  继承自BroadcastReceiver,并重写父类的onReceive()方法
  才能称此为广播
 */
public class MyReceiver extends BroadcastReceiver {
    @Override  //重写onReceive方法
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "android.intent.action.BOOT_COMPLETED", Toast.LENGTH_LONG).show();
    }
}
/*
  注意：静态的广播接收器一定要在AndroidManifest.xml文件中注册才可以使用
 */