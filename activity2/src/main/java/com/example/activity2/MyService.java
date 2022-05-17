package com.example.activity2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
/*
 必须继承service才能是服务组件
 【Service服务的生命周期】  【Service既不是进程也不是线程】
 Service(服务)是在【后台执行长时间运行操作】而【没有用户界面的组件】。它运行于UI线程，因此不能进行耗时的操作。
 进程是系统最小资源分配单位，而线程是最小的执行单位
 Android的后台就是指，它的运行是完全不依赖UI的。
 即使Activity被销毁，或者程序被关闭，只要进程还在，Service就可以继续运行。
 Service确实是运行在主线程里的

 */
public class MyService extends Service {
    private final String TAG = MyService.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "--->onCreate: ");
        //在MyService的onCreate()方法里也加入一行打印当前线程id的语句：
        Log.d("MyService", "MyService thread id is " + Thread.currentThread().getId());
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "--->onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "--->onDestroy: ");
    }
//***************** onBind()绑定服务 和 onUnbind()解绑服务 *************************
    @Nullable
    @Override
    public IBinder onBind(Intent intent) { //IBinder接口
        Log.d(TAG, "--->onBind: ");
        return null;//请务必实现此方法，但如果您并不希望允许绑定，则应返回 null。
      //先 --->onCreate:  再 --->onBind
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "--->onUnbind: ");
        return super.onUnbind(intent);
        //--->onUnbind:   接着   --->onDestroy:这是服务接收的最后一个调用。
    }
}

/*
比如说一些应用程序，始终需要与服务器之间始终保持着心跳连接，就可以使用Service来实现。
在这里一直执行着心跳连接，难道就不会阻塞主线程的运行吗？
当然会，但是我们可以在【Service中】再创建一个【子线程Thread】，然后在这里去处理耗时逻辑就没问题了。
那为什么不直接在Activity里创建呢？
1.这是因为Activity很难对Thread进行控制，当Activity被销毁之后，就没有任何办法可以再重新获取到之前创建的【子线程的实例】。
2.而且在一个Activity中创建的子线程，另一个Activity无法对其子线程进行操作。
3.但是Service就不同了，所有的Activity都可以与Service进行关联，可以很方便地操作其中的方法，即使Activity被销毁了，之后只要重新与Service建立关联，就又能够获取到【原有的Service中Binder的实例】。
4.因此，【使用Service来处理后台任务】，Activity就可以放心地finish，完全不需要担心无法对后台任务进行控制的情况。


 */