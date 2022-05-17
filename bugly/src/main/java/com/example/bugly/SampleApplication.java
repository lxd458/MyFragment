package com.example.bugly;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
/*
自定义Application:初始化SDK enableProxyApplication = false 的情况
 */
public class SampleApplication extends TinkerApplication {
    public SampleApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.example.bugly.SampleApplicationLike",
                "com.tencent.tinker.loader.TinkerLoader", false,true);
    }
}