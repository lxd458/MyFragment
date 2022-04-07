package com.example.addmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 动态添加Fragment :activity发送信息到Fragment
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //一、
        Button t1 = findViewById(R.id.btn);
        Button t2 = findViewById(R.id.btn2);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //二、switch case语句实现切换，点击按钮创建Fragment
            case R.id.btn :
                /* 一、在一个Bundle存储信息，传入到Fragment里面，通过获取key拿到value*/
                Bundle bundle = new Bundle();//创建Bundle对象
                bundle.putString("msg","喜欢你");
                BlankFragment1 bf = new BlankFragment1();//添加BlankFragment1对象
                bf.setArguments(bundle);//设置bundle参数
                //2.Activity引入接口方法：通过匿名内部类调用接口对象
                bf.FragmentCallback(new FragmentCallback() { //两个接口方法
                    @Override //Fragment发送
                    public void sendMsgToActivity(String string) {
                        //打印一下：
                        Toast.makeText(MainActivity.this,string,Toast.LENGTH_SHORT).show();
                    }
                    @Override//Fragment接收
                    public String getMsgFromActivity(String string) {
                        //Activity:需要返回一个字符串
                        return "你好，我来自Activity";
                    }
                });

                replaceFragment(bf);//会自动创建一个xml;
                break;
            case R.id.btn2 : replaceFragment(new ItemFragment());//自动创建两个xml
        }
    }
    //三、动态切换fragment
    private void replaceFragment(Fragment fragment) {//需要传入一个fragment片段
        //1.获取片段管理器
        FragmentManager manager = getSupportFragmentManager();
        //2.开始事务
        FragmentTransaction transaction = manager.beginTransaction();
        //3.调用fragment替换方法
        transaction.replace(R.id.frame,fragment);
     //   transaction.addToBackStack("null");
        transaction.commit();//提交事件

    }
}
