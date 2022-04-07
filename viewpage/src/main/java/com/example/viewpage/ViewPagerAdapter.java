package com.example.viewpage;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder> {
  private List<String> data = new ArrayList<>();//String页面视图集合绑定
 private List<Integer>  colors = new ArrayList<>();//Integer颜色集合绑定
    public ViewPagerAdapter(){ //无参构造，适配的数据【页面内容+页面背景色】
        data.add("页面一");//String
        data.add("页面二");
        data.add("页面三");
        data.add("页面四");
        data.add("页面五");
        data.add("页面六");

        colors.add(R.color.red);//把color的颜色设置在color.xml
        colors.add(R.color.yellow);//Integer
        colors.add(R.color.colorAccent);
        colors.add(R.color.green);
        colors.add(R.color.blue);
        colors.add(R.color.colorPrimary);

    }
/*
  class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>{}
   onCreateViewHolder()
   onBindViewHolder()
   getItemCount()
   class ViewPagerHolder extends  RecyclerView.ViewHolder{}
 */

    @NonNull
    @Override
    public ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpage,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHolder holder, int position) {
        //将适配的数据进行绑定多个页面，
      holder.textView.setText(data.get(position));//文本标签显示适配内容，获取定位
        //绑定相关的颜色属性
        holder.relativeLayout.setBackgroundResource(colors.get(position));//setBackgroundResource资源方法
    }

    @Override
    public int getItemCount() {
        return data.size();//自定义声明多少个页面:也可以是具体数值5
    }


    /*创建ViewPagerHolder类，继承RecyclerView.ViewHolder*/
    class ViewPagerHolder extends  RecyclerView.ViewHolder{
        TextView textView;
        RelativeLayout relativeLayout;
        public ViewPagerHolder(@NonNull View itemView) {
            super(itemView);
            //引入viewpage.xml中父子组件id
            relativeLayout = itemView.findViewById(R.id.container);//根容器id/
            textView = itemView.findViewById(R.id.tv);//子容器，组件

        }
        }
}
