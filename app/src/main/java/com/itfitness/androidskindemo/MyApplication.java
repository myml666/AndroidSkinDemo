package com.itfitness.androidskindemo;

import android.app.Application;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

/**
 * @ProjectName: AndroidSkinDemo
 * @Package: com.itfitness.androidskindemo
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @Author: LML
 * @CreateDate: 2018/9/19 16:23
 * @UpdateUser: 更新者：
 * @UpdateDate: 2018/9/19 16:23
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinCompatManager.withoutActivity(this)                         // 基础控件换肤初始化
                .addInflater(new SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
                .addInflater(new SkinCardViewInflater())                // CardView v7 控件换肤初始化[可选]
                .setSkinStatusBarColorEnable(true)                      //切换状态栏颜色
//                .setSkinStatusBarColorEnable(false)                     // 关闭状态栏换肤，默认打开[可选]
//                .setSkinWindowBackgroundEnable(false)                   // 关闭windowBackground换肤，默认打开[可选]
                .loadSkin();
    }
}
