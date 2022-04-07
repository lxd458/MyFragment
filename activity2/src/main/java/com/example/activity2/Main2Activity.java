package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

/**
 *  Main2Activity 实现 静态注册广播
 */
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         //动态注册步骤
      MyReceiver2 m2=  new MyReceiver2();//创建对象类，
        IntentFilter tf = new IntentFilter();//创建过滤器
     tf.addAction(ActionUtils.Action_dynamic);//保持标记一致
      registerReceiver(m2,tf);//完成注册


    }
  /*
   静态注册后，发送消息给接收者 setAction()
   */
    public void sendBoardCast(View view) {
        //注册标记必须一致
      Intent intent =   new Intent();
      intent.setAction(ActionUtils.Action_Static);
      sendBroadcast(intent);
    }
}
