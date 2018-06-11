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
//

        XposedHelpers.findAndHookMethod(
                XposedHelpers.findClass("com.tencent.assistant.g.g",loadPackageParam.classLoader),
                "a",
                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.StatAppDownlaodWithChunk",loadPackageParam.classLoader),
                String.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        Object result = param.args[0];
                        Class JceStruct = XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader);
                        Method toString = XposedHelpers.findMethodBestMatch(JceStruct, "toString");
                        String res = (String)toString.invoke(result);

                        XposedBridge.log("StatAppDownlaodWithChunk: " + res);

                    }
                    //
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    }
                });



        XposedHelpers.findAndHookMethod(
                XposedHelpers.findClass("com.tencent.assistant.utils.f",loadPackageParam.classLoader),
                "a",
                int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        int p1 = (int)param.args[0];
                        XposedBridge.log("f.a: " + String.valueOf(p1));

                    }
                    //
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        byte[] p2 = (byte[]) param.getResult();
                        printByteArray("response d.a result: " , p2);
                    }
                });



//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.protocol.k",loadPackageParam.classLoader),
//                "a",
//                byte[].class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] p1 = (byte[]) param.args[0];
//                        printByteArray("response k.a p1: " ,  p1);
////                        byte[] tmp = {(byte)0x0A,(byte)0x00,(byte)0x01,(byte)0x10,(byte)0x04,(byte)0x21,(byte)0x07,(byte)0x04,(byte)0x39,(byte)0x0C,(byte)0x4C,(byte)0x56,(byte)0x00,(byte)0x66,(byte)0x0F,(byte)0x32,(byte)0x31,(byte)0x31,(byte)0x2E,(byte)0x31,(byte)0x30,(byte)0x33,(byte)0x2E,(byte)0x31,(byte)0x38,(byte)0x35,(byte)0x2E,(byte)0x31,(byte)0x34,(byte)0x37,(byte)0x70,(byte)0x02,(byte)0x8A,(byte)0x0C,(byte)0x1D,(byte)0x00,(byte)0x0C,(byte)0x0B,(byte)0x9A,(byte)0x0C,(byte)0x1D,(byte)0x00,(byte)0x0C,(byte)0x0B,(byte)0xA2,(byte)0x5B,(byte)0x17,(byte)0xA5,(byte)0x89,(byte)0xBC,(byte)0xCC,(byte)0xDC,(byte)0xE3,(byte)0x02,(byte)0x2A,(byte)0x43,(byte)0x2D,(byte)0x92,(byte)0x07,(byte)0x80,(byte)0xD0,(byte)0xF8,(byte)0x0F,(byte)0x00,(byte)0x01,(byte)0x06,(byte)0x0C,(byte)0x6D,(byte)0x61,(byte)0x2E,(byte)0x33,(byte)0x67,(byte)0x2E,(byte)0x71,(byte)0x71,(byte)0x2E,(byte)0x63,(byte)0x6F,(byte)0x6D,(byte)0x19,(byte)0x0C,(byte)0xF6,(byte)0x10,(byte)0x00,(byte)0xF6,(byte)0x11,(byte)0x00,(byte)0xFA,(byte)0x12,(byte)0x0C,(byte)0x19,(byte)0x0C,(byte)0x2C,(byte)0x0B,(byte)0xF9,(byte)0x13,(byte)0x0C,(byte)0x0B,(byte)0x1D,(byte)0x00,(byte)0x00,(byte)0x10,(byte)0xE9,(byte)0x1D,(byte)0xE4,(byte)0xFB,(byte)0x96,(byte)0x48,(byte)0xD8,(byte)0xDA,(byte)0xA1,(byte)0x74,(byte)0xC6,(byte)0x38,(byte)0x66,(byte)0x5D,(byte)0xD1,(byte)0xF0};
////                        param.args[0] = tmp;
//                    }
//                    //
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        Object  result = param.getResult();
//                        Class JceStruct = XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader);
//                        Method toString = XposedHelpers.findMethodBestMatch(JceStruct, "toString");
//                        String res = (String)toString.invoke(result);
//
//                        XposedBridge.log("response  k.a classname:  " +  result.getClass().getName() + "  /r/n result: " + res);
//                    }
//                });
//
//
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.login.d",loadPackageParam.classLoader),
//                "a",
//                boolean.class,
//                byte[].class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                        byte[] p2 = (byte[]) param.args[1];
//                        printByteArray("response  d.a p1: " ,  p2);
//                    }
//                    //
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] p2 = (byte[]) param.getResult();
//                        printByteArray("response d.a result: " , p2);
//                    }
//                });
//
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.login.d",loadPackageParam.classLoader),
//                "b",
//                boolean.class,
//                byte[].class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                        byte[] p2 = (byte[]) param.args[1];
//                        printByteArray("response d.b p1: " ,  p2);
//                    }
//                    //
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] p2 = (byte[]) param.getResult();
//                        printByteArray("response d.b result: " , p2);
//                    }
//                });
//
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.utils.ax",loadPackageParam.classLoader),
//                "b",
//                byte[].class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                        byte[] p2 = (byte[]) param.args[0];
//                        printByteArray("response ax.b p1: " ,  p2);
//                    }
//                    //
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] p2 = (byte[]) param.getResult();
//                        printByteArray("response ax.b result: " , p2);
//                    }
//                });
//
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.protocol.k",loadPackageParam.classLoader),
//                "a",
//                XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader),
//                byte[].class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                        Object  p1 = (Object) param.args[0];
//                        byte[] p2 = (byte[]) param.args[1];
//
//                        XposedBridge.log("response k.a p1 " + p1.getClass().getName());
//                        printByteArray("response k.a p2: " ,  p2);
//                    }
////
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        Object  result = param.getResult();
//                        Class JceStruct = XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader);
//                        Method toString = XposedHelpers.findMethodBestMatch(JceStruct, "toString");
//                        String res = (String)toString.invoke(result);
//
//                        XposedBridge.log("response k.a classname:  " +  result.getClass().getName() + "  /r/n result: " + res);
//
//
//                    }
//                });
////

        XposedHelpers.findAndHookMethod(
                XposedHelpers.findClass("com.tencent.assistant.protocol.k",loadPackageParam.classLoader),
                "a",
                int.class,
                int.class,
                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.Net",loadPackageParam.classLoader),

                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable{
                        Object  result = param.getResult();
                        Class JceStruct = XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader);
                        Method toString = XposedHelpers.findMethodBestMatch(JceStruct, "toString");
                        String res = (String)toString.invoke(result);

                        XposedBridge.log("response k.a classname:  " +  result.getClass().getName() + "  /r/n result: " + res);
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
