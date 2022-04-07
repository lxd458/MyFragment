package com.example.addmanage;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
/*
  Fragment依赖于Activity生存
 */

public class BlankFragment1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "BlankFragment1" ;//


    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private View fragView;//

    public BlankFragment1() {

    }

   //2.声明外部接口的变量
    private FragmentCallback fragmentCallback;
    //3.对外提供公共的调用函数
   public  void FragmentCallback (FragmentCallback callback){
        fragmentCallback=callback;//方便赋值调用
   }
 //============================================================
 @Override
 public void onAttach(Context context) {
     super.onAttach(context);
     if (context instanceof OnFragmentInteractionListener) {
         mListener = (OnFragmentInteractionListener) context;
     } /////【去掉else语句】
     Log.d(TAG, "onAttach: ");
 }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//第一行
        /*二、在BlankFragment查看消息*/
        Bundle bundle = this.getArguments();//获取参数
        String str = bundle.getString("msg");//获取key
        Log.e(TAG, "onCreate: "+str );//run打印：喜欢你

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       //在onCreateView方法：去调用activity生成的接口对象里面的接口方法
        //通过触发按钮的绑定事件
        if(fragView==null){ //先获取具体xml
            fragView = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        }
        //再获取按钮id
        Button button = fragView.findViewById(R.id.fragBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*通过声明的接口变量，调用具体的接口方法 */
                //[1]Fragemnet发送消息
            //    fragmentCallback.sendMsgToActivity("你好，我是Fragemnet");
                //[2]Fragemnet获取消息
                String msg = fragmentCallback.getMsgFromActivity("null");
                //打印     BlankFragment1没有上下文，所以需要先取到
                Toast.makeText(BlankFragment1.this.getContext(),msg,Toast.LENGTH_SHORT).show();
            }
        });
        Log.d(TAG, "onCreateView: ");
        return fragView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
