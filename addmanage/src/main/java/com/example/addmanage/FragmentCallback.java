package com.example.addmanage;

public interface FragmentCallback {
    //1.添加接口信息，定义两个接口方法【抽象方法】
    void sendMsgToActivity(String string); //这里规定参数为字符串
    String getMsgFromActivity(String string);
}

/*
Fragement   =====发消息=======>  activity
Fragement   <=====拿消息=======  activity
 */