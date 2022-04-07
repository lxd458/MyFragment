package com.example.wechatpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.widget.ViewPager2;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
                                                  //2.3实现点击事件
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 private LinearLayout llChat,llContact,llFind,llMy;
 private ImageView ivChat,ivContact,ivFind,ivMy,ivCurrent;
  ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();//1.1调用方法实现分页切屏
        initTabView();//2.1实现表格选框栏
    }

    @SuppressLint("WrongViewCast")
    private void initTabView() { //2.2需要分别获取imageview和textview
        llChat = findViewById(R.id.wx);
        llChat.setOnClickListener(this);//2.4设置触发监听

        llContact= findViewById(R.id.lxr);
        llContact.setOnClickListener(this);

        llFind = findViewById(R.id.find);
        llFind.setOnClickListener(this);

        llMy = findViewById(R.id.my);
        llMy.setOnClickListener(this);
//        imageview
          ivChat = findViewById(R.id.iv_wx);
          ivContact = findViewById(R.id.iv_lxr);
          ivFind = findViewById(R.id.iv_find);
          ivMy = findViewById(R.id.iv_my);
//   TextView
        ivChat.setSelected(true);
        ivCurrent=ivChat;

    }

    private void initPager() {
        //1.4创建Fragment集合
        ArrayList<Fragment> fragment = new ArrayList<>();//
        fragment.add(0,BlankFragment.newInstance("聊天"));//而不是直接new BlankFragment()对象
        fragment.add(1,BlankFragment.newInstance("通信录"));
        fragment.add(2,BlankFragment.newInstance("发现"));
        fragment.add(3,BlankFragment.newInstance("我的"));
       //1.2 获取视图id
        viewPager2 = findViewById(R.id.vp);
        //1.3不在使用自定义的Adapter,使用FragmentAdapter
        FragmentAdapter fragmentPagerAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle(), fragment);
        viewPager2.setAdapter(fragmentPagerAdapter);//往ViewPager2添加适配器
       /*2.6 注册页面更改回调函数*/
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                //2.7实现同步滑动
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
//-----------------------注意该方法的位置：位于initPager()方法外，生成------------------------------------
         private void changeTab(int position) {
             //有多个需要同步滑动的表格:图标跟着变动
               //2.9实现图标的复位，还原
                    ivCurrent.setSelected(false);
            /*2.8所以采用switch-case语句:*/
                switch (position){
                    //判断具体哪个id，根据事件id点击事件和viewpage联动
               case  R.id.wx : viewPager2.setCurrentItem(0); //1
               case 0 : ivChat.setSelected(true);
                     ivCurrent = ivChat;//2.9.1赋值
                           break;

              case  R.id.lxr: viewPager2.setCurrentItem(1);//  2
              case  1:  ivContact.setSelected(true);
                   ivCurrent = ivContact;
                    break;

                    case R.id.find : viewPager2.setCurrentItem(2); //    3
                        case  2:  ivFind.setSelected(true);
                              ivCurrent = ivFind;
                              break;

                    case R.id.my :  viewPager2.setCurrentItem(3);  // 4
                           case 3:   ivMy.setSelected(true);
                              ivCurrent = ivMy;
                                   break;
                                      }
                             }

    @Override //2.5  实现implements View.OnClickListener ；需要重写onClick方法
    public void onClick(View view) {
       //3.获取绑定事件的id
        changeTab(view.getId());//0 , 1 ,2 ,3
    }



                                                   
        /*
        FragmentManager fragmentMannager  ===> getSupportFragmentManager()
        LifeCycle lifecycle  =============> getLifecycle()
         */
}
