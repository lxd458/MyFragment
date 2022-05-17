package com.example.amap_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        AMap aMap = mapView.getMap();
    }
}
/*Execution failed for task ':amap_gd:mergeDebugJavaResource'.
> A failure occurred while executing com.android.build.gradle.internal.tasks.Workers$ActionFacade
   > More than one file was found with OS independent path 'assets/ae/res.ck'
任务执行失败:AMAP _ GD:mergedebugjavaresource & apos；出现故障
 */