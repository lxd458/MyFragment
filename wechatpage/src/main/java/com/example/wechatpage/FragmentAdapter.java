package com.example.wechatpage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

/*
创建一个适配器类，继承FragmentStateAdapter碎片状态适配器
 */
public class FragmentAdapter extends FragmentStateAdapter {
    //创建List集合，注意泛型为：Fragment
    List<Fragment> fragmentList = new ArrayList<>();


    //选择参数最多的构造方法： 参数：片段管理器，生命周期，具体片段
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle,List<Fragment> fragment) {
        super(fragmentManager, lifecycle);
        fragmentList=fragment;//参数值传递
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) { //get()
        return fragmentList.get(position);//生成片段，获取具体位置
    }

    @Override
    public int getItemCount() { //size()
        return fragmentList.size();//返回页面切屏个数
    }
}
