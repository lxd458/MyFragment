package com.example.viewpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

   private ViewPager2 v2;//在哪里使用ViewPager2？ 位置build.gradle文件下面
  /* implementation 'androidx.viewpager2:viewpager2:1.0.0'
   在activity_main.xml文件中使用该标签名
   注意名字不能起冲突了。
   */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   /*
     实现多个页面切换，左右滑屏
    */
        v2= findViewById(R.id.vp);
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter() ;
        v2.setAdapter(viewPagerAdapter);

    }
}
