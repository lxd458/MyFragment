package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//【标题：Activity的跳转】
public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "----->onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "----->onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "----->onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "----->onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "----->onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "----->onResume: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "----->onDestroy: ");
    }
    /*  1. android:onClick="startAvtivity"    【activity_main.xml】
     2.<activity android:name=".MainActivity2"/>   【AndroidMainfest.xml】
  3. 通过按钮来触发点击事件，完成第一个活动窗口跳转到第二个活动窗口
 */

    public void startAvtivity(View view) {
        startActivity(new Intent(this,MainActivity2.class));//context,class
    }
}
