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
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.utils.g",loadPackageParam.classLoader),
//                "a",
//                byte[].class,
//                int.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
////                        byte[] p1 = (byte[])param.args[0];
////                        byte[] p2 = (byte[])param.args[3];
////                        printByteArray("zds p1",p1);
////                        printByteArray("zds p2",p2);
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] r1 = (byte[])param.getResult();
//                        printByteArray("zds gabi:", r1);
//                    }
//                });
//
//
//
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.utils.g",loadPackageParam.classLoader),
//                "a",
//                byte[].class,
//                int.class,
//                int.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] p1 = (byte[])param.args[0];
//                        printByteArray("zds p1",p1);
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        long r1 = (long)param.getResult();
//                        printlog("gabii r: " ,  r1);
//                    }
//                });
//
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.utils.g",loadPackageParam.classLoader),
//                "a",
//                byte[].class,
//                int.class,
//                int.class,
//                byte[].class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] p1 = (byte[])param.args[0];
//                        byte[] p2 = (byte[])param.args[3];
//                        printByteArray("zds p1",p1);
//                        printByteArray("zds p2",p2);
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] r1 = (byte[])param.getResult();
//                        printByteArray("zds r1", r1);
//                    }
//                });
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.utils.g",loadPackageParam.classLoader),
//                "b",
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        param.setResult(5);
//                    }
//                });
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
//                        boolean b = (boolean) param.args[0];
//                        printlog("login.d.b param 0:", b);
//                        byte[] p = (byte[]) param.args[1];
//                        printlog("login.d.b param 1 size:", p.length);
//                        printByteArray("login.d.b param 1:" ,  p);
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] r = (byte[])param.getResult();
//                        printByteArray("login.d.b result:" ,  r);
//                    }
//                });
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
//                        byte[] p = (byte[]) param.args[1];
//                        printByteArray("login.d.a param:" ,  p);
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] r = (byte[])param.getResult();
//                        printByteArray("login.d.a result:" ,  r);
//                    }
//                });


        XposedHelpers.findAndHookMethod(
                XposedHelpers.findClass("com.tencent.assistant.utils.g",loadPackageParam.classLoader),
                "a",
                byte[].class,
                int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[] p = (byte[]) param.args[0];
//                        printByteArray("utils.g.abi:" ,  p);
                        param.args[0] = new byte[]{(byte)0x71,(byte)0x45,(byte)0xEB,(byte)0xE8,(byte)0x62,(byte)0x95,(byte)0xF5,(byte)0xC7};

                        printlog("utils.g.abi int= ", (int)param.args[1]);

                        Class cls = XposedHelpers.findClass("com.tencent.assistant.utils.g",loadPackageParam.classLoader);
                        Field field = cls.getDeclaredField("h");
                        field.setAccessible(true);
                        byte[] h = (byte[])field.get(param.thisObject);

                        printByteArray("utils.g.abi h: ", h);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        byte[] r = (byte[])param.getResult();
                        printByteArray("utils.g.abi result:" ,  r);
                    }
                });

    }

    private static void  printlog(String tag, int b){
        XposedBridge.log(tag + ": "  + b);
    }

    private static void  printlog(String tag, long b){
        XposedBridge.log(tag + ": "  + b);
    }

    private static void  printlog(String tag, boolean b){
        XposedBridge.log(tag + ":  " + b);
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
