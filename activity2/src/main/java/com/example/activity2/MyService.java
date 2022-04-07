package com.example.activity2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
/*
 必须继承service才能是服务组件
 【Service服务的生命周期】
 */
public class MyService extends Service {
    private final String TAG = MyService.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "--->onCreate: ");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "--->onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "--->onDestroy: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "--->onBind: ");
        return null;

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "--->onUnbind: ");
        return super.onUnbind(intent);
    }
}
