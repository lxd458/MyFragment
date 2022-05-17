package com.example.activity2;
/*
  服务相关：可以具体查看demo_service模块 == activity2里面的MainActivity
  结构类似，方法类似，打印结果类似。
 */
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
/* 【MainActivity 与 Service 服务相关】
   1.开启服务和关闭服务
   2.绑定服务和解绑服务
   3.需要使用服务桥梁：ServiceConnection对象
 */
public class MainActivity extends AppCompatActivity {

    @Override  //onCreate()方法
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //在MainActivity的onCreate()方法里加入一行打印当前线程id的语句：
        Log.d("MyService", "MainActivity thread id is " + Thread.currentThread().getId());
    }

    /*
     1.通过两个按钮事件，完成[服务的开启和关闭]
     startService()
     stopService()
     当注意 使用 startService 启动服务之后，一定要使用 stopService停止服务
     */
    public void startService(View view) {
        //方法名 startService()
        startService( new Intent(this,MyService.class));
    }
    public void stopService(View view) {
        //方法名 stopService()
        stopService(new Intent(this,MyService.class));
    }
/*
   2.通过两个按钮事件，完成【服务绑定和服务解绑】,需要单独创建MyService类继承Service 进行实现
   bindService()
   unbindService()

 */
    public void bindService(View view) {
        bindService(new Intent(this,MyService.class),connection, Context.BIND_AUTO_CREATE);
    }
    public void unbindService(View view) {
        unbindService(connection);
    }

    //2.1 【活动和服务之间的绑定需要桥梁：ServiceConnection对象 】声明的对象，以及实现方法
    private ServiceConnection connection = new ServiceConnection() {
        @Override //重写服务连接
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }
        @Override //重写服务断联
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

//2.2 设置自动解绑

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unbindService(connection);
//    }

}
