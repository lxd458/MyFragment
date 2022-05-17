package com.example.activity2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;



/*
  动态的广播接收器，动态注册
   继承自BroadcastReceiver,并重写父类的onReceive()方法
 */
public class MyReceiver2 extends BroadcastReceiver {
    private final String TAG = MyReceiver2.class.getSimpleName();//
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: 动态注册");
        /*
         //这里需要权限，需要在AndroidManifest.xml中进行网络访问权限申请:
       //<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
         */
//        ConnectivityManager connectionManager = (ConnectivityManager) context.getSystemService(TAG);
//        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
//        if (networkInfo != null && networkInfo.isAvailable()) {
//            //有网
//            Toast.makeText(context, "network is available",Toast.LENGTH_SHORT).show();
//        } else {
//            //无网
//            Toast.makeText(context, "network is unavailable",Toast.LENGTH_SHORT).show();
//        }

    }





}
