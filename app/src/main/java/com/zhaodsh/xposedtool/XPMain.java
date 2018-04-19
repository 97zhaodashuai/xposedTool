package com.zhaodsh.xposedtool;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XPMain implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {

        //yyb
        if(loadPackageParam.packageName.contains("com.tencent.android.qqdownloader")){
            yybhook.init(loadPackageParam);
        }


    }
}
