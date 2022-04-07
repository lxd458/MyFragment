package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     1.通过两个按钮事件，完成服务的开启和关闭
     */
    public void startService(View view) {
        //方法名
        startService( new Intent(this,MyService.class));
    }
    public void stopService(View view) {
        stopService(new Intent(this,MyService.class));
    }
/*
   2.通过两个按钮事件，完成服务的绑定和解绑
 */
    public void bindService(View view) {
        bindService(new Intent(this,MyService.class),connection, Context.BIND_AUTO_CREATE);
    }

    public void unbindService(View view) {
        unbindService(connection);
    }
    //2.1 活动和服务之间的桥梁;声明的对象，以及实现方法
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

//    @Override //2.2 设置自动解绑
//    protected void onDestroy() {
//        super.onDestroy();
//        unbindService(connection);
//    }

}
