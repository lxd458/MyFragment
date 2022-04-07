package com.example.wechatpage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
  右键创建一个BlankFragment类，继承Fragment
 */
public class BlankFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";//字符串信息

   private View rootView ;//onCreateView（）创建View

    private String mText;//表示TextView里面展现的字符串信息

    private List<Integer> colors = new ArrayList<>();


    public BlankFragment() {
        // 空参构造
        colors.add(0,R.color.red);//colors.xml
    }
   /*三个方法：
     newInstance(String param1)
     onCreate(Bundle savedInstanceState)
     onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    */
   //newInstance() 方法新建实例 【后面Activity需要调用该类下的该方法】
    //该方法下的参数类型为String
    public static BlankFragment newInstance(String param1) {

        //1.new BlankFragment()
        BlankFragment fragment = new BlankFragment();
        //2.new Bundle() 【activity的信息】
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);//key 和 value
         /*setArguments(args)*/
        fragment.setArguments(args); //【fragment设置参数信息】
        return fragment; //BlankFragment
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*getArguments()*/
        if (getArguments() != null) {
            mText = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 不建议直接返回xml的layout组件
        if(rootView==null){
            rootView  = inflater.inflate(R.layout.fragment_blank, container, false);

        }
        initView();

        return rootView;
    }

    private void initView() {
       TextView textView = rootView.findViewById(R.id.tv);//获取视图id
       textView.setText(mText);//把Txet内容放到TextView中进行展现
    }


}
