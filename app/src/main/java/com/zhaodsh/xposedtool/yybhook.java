package com.zhaodsh.xposedtool;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class yybhook {

    public static void init(final XC_LoadPackage.LoadPackageParam loadPackageParam) {

        XposedHelpers.findAndHookMethod(
                XposedHelpers.findClass("com.tencent.assistant.protocol.k",loadPackageParam.classLoader),
                "a",
                int.class, int.class,
                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.Net",loadPackageParam.classLoader),
                XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader),
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        Class JceStruct = XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader);
                        Method toString = XposedHelpers.findMethodBestMatch(JceStruct, "toString");
                        Object p3 = (Object)param.args[2];
                        Object p4 = (Object)param.args[3];

                        String res = (String)toString.invoke(p3);
                        XposedBridge.log("1 k.a p3: " + res);

                        res = (String)toString.invoke(p4);
                        XposedBridge.log("1 k.a p4: " + res);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Object  result = param.getResult();
                        Class JceStruct = XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader);
                        Method toString = XposedHelpers.findMethodBestMatch(JceStruct, "toString");
                        String res = (String)toString.invoke(result);
                        XposedBridge.log("result: " + res);
                    }
                });


                XposedHelpers.findAndHookMethod(
                XposedHelpers.findClass("com.tencent.assistant.utils.g",loadPackageParam.classLoader),
                "a",
                byte[].class,
                byte[].class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        byte[] p1 = (byte[])param.args[0];
                        byte[] p2 = (byte[])param.args[1];
                        printByteArray("zds p1",p1);
                        printByteArray("zds p2",p2);

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        byte[] r1 = (byte[])param.getResult();
                        printByteArray("zds r1", r1);
                    }
                });


        XposedHelpers.findAndHookMethod(
                XposedHelpers.findClass("com.tencent.assistant.utils.g",loadPackageParam.classLoader),
                "b",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(5);
                    }
                });

    }




    private static void  printByteArray(String tag, byte[] bytes){
        XposedBridge.log(tag + ": " + ByteArrayToHexString(bytes));
    }
    private static String ByteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }


}
