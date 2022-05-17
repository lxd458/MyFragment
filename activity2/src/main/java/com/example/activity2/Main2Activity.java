package com.example.activity2;
/*
   广播是什么？ 一种在应用程序之间传输信息的机制。 广播内容==intent==发生数据
   广播的使用场景:
  a.同一app内有多个进程的不同组件之间的消息通信。
  b.不同app之间的组件之间消息的通信

无序广播:context.sendBroadcast(Intent)方法发送的广播，不可被拦截,接收者不可修改数据
有序广播:context.sendOrderBroadcast(Intent)方法发送的广播，可被拦截，接收者可以修改数据
本地广播:
  localBroadcastManager.sendBroadcast(Intent)，只在app内传播。
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

/*  Main2Activity   ====》 activty_main2.xml 【广播相关】
 *  MyReceiver2 实现 动态、静态注册广播
 * 动态注册广播接收器的优点以及缺点：
 * 动态注册的广播接收器：可以自由地控制注册与注销，在灵活性方面有很大优势，
 * 缺点是：必须要在程序启动之后才能接收到广播，因为注册的逻辑是写在onCreate()方法中的。
 *
 * 在程序未启动的情况下就能接收到广播：静态注册的广播接收器就可以做到。
 */
public class Main2Activity extends AppCompatActivity {
  //需要注入MyReceiver2类
    private  MyReceiver2 myReceiver2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         //一、动态注册步骤 在onCreate方法里面!!!!!!!
      MyReceiver2 m2=  new MyReceiver2();//1.创建MyReceiver2对象类，
      IntentFilter tf = new IntentFilter();//2.创建IntentFilter过滤器
      tf.addAction(ActionUtils.Action_dynamic);//3、addAction 保持标记一致
        //tf.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      registerReceiver(m2,tf);//完成注册:调用注册接收器 registerReceiver()
    /*
      最后发送弹框提示：android.net.conn.CONNECTIVITY_CHANGE
     */

    }
  /*
       二、静态注册后，发送消息给接收者 setAction()
       【发送广播：按钮触发事件!!!】
        java.lang.IllegalStateException: Could not execute method for android:onClick
   */
    public void send(View view) {
        //注册标记必须一致
      Intent intent =  new Intent(); //创建Intent对象携带标记：setAction
      intent.setAction(ActionUtils.Action_Static);
      sendBroadcast(intent);

      /* reflect.InvocationTargetException
      SecurityException: Permission Denial: not allowed to send broadcast android.intent.action.BOOT_COMPLETED from pid=14352, uid=10064
       */
    }
// 三、自动取消注册
//    protected void onDestroy(){
//        unregisterReceiver(myReceiver2);//一定要记得取消广播接收器的注册
//        super.onDestroy();
//    }

}
