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

//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.protocol.l",loadPackageParam.classLoader),
//                "a",
//                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.Request",loadPackageParam.classLoader), new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                XposedBridge.log(new Exception("new stack"));
//
//                Object param_0 = (Object) param.args[0];
//                Field  field = XposedHelpers.findField(XposedHelpers.findClass("com.tencent.assistant.protocol.jce.Request",loadPackageParam.classLoader), "body");
//                byte[] tmp = (byte[])field.get(param_0);
//                XposedBridge.log(ByteArrayToHexString(tmp));
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//
//            }
//        });

//        XposedHelpers.findAndHookMethod(
//            XposedHelpers.findClass("com.tencent.assistant.protocol.k",loadPackageParam.classLoader),
//            "a",
//            int.class, int.class,
//            XposedHelpers.findClass("com.tencent.assistant.protocol.jce.Net",loadPackageParam.classLoader),
//            new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                }
//
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    Object  result = param.getResult();
//                        Class JceStruct = XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader);
//                        Method toString = XposedHelpers.findMethodBestMatch(JceStruct, "toString");
//                        String res = (String)toString.invoke(result);
//                        XposedBridge.log("res: " + res);
//                }
//            });


        XposedHelpers.findAndHookMethod(
                XposedHelpers.findClass("com.tencent.assistant.protocol.k",loadPackageParam.classLoader),
                "a",
                int.class, int.class,
                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.Net",loadPackageParam.classLoader),
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                        int p1 = (int)param.args[0];
                        int p2 = (int)param.args[1];

                        XposedBridge.log("p1: " + p1);
                        XposedBridge.log("p2: " + p2);

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Object  result = param.getResult();
                        Class JceStruct = XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader);
                        Method toString = XposedHelpers.findMethodBestMatch(JceStruct, "toString");
                        String res = (String)toString.invoke(result);
                        XposedBridge.log("res: " + res);
                    }
                });


//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.protocol.l",loadPackageParam.classLoader),
//                "a",
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                        byte[] result = (byte[])param.getResult();
////                        XposedBridge.log("l.a: " + ByteArrayToHexString(result));
//                    }
//                });



//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.protocol.l",loadPackageParam.classLoader),
//                "a",
//                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.Request",loadPackageParam.classLoader),
//                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.Net",loadPackageParam.classLoader),
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        Object  obj = (Object)param.args[0];
////                        XposedBridge.log("getSimpleName " + obj.getClass().getSimpleName());
////                        XposedBridge.log("getCanonicalName " + obj.getClass().getCanonicalName());
////                        XposedBridge.log("getName " + obj.getClass().getName());
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                        byte[] result = (byte[])param.getResult();
////                        XposedBridge.log("l.a: " + ByteArrayToHexString(result));
//                    }
//                });


//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.protocol.h",loadPackageParam.classLoader),
//                "a",
//                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.Request",loadPackageParam.classLoader),
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        Object  obj = (Object)param.args[0];
////                        XposedBridge.log("getSimpleName " + obj.getClass().getSimpleName());
////                        XposedBridge.log("getCanonicalName " + obj.getClass().getCanonicalName());
////                        XposedBridge.log("getName " + obj.getClass().getName());
//                        XposedBridge.log(new Exception("new stack"));
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                        byte[] result = (byte[])param.getResult();
////                        XposedBridge.log("l.a: " + ByteArrayToHexString(result));
//                    }
//                });






//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.component.appdetail.e",loadPackageParam.classLoader),
//                "getStInfo",
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                        XposedBridge.log(new Exception("appdetail.e.getStInfo  zhan"));
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        Object res = (Object) param.getResult();
//
//                        Class STInfoV2 = XposedHelpers.findClass("com.tencent.assistantv2.st.model.STCommonInfo",loadPackageParam.classLoader);
//                        Field field  = STInfoV2.getDeclaredField("recommendId");
//                        byte[] ba = (byte[])field.get(res);
//                        XposedBridge.log("extractdata: " + ByteArrayToHexString(ba));
//
//                    }
//                });
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistantv2.activity.AppDetailActivityV5",loadPackageParam.classLoader),
//                "O",
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                        XposedBridge.log(new Exception("AppDetailActivityV5.o  zhan"));
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                        Object res = (Object) param.getResult();
////
////                        Class STInfoV2 = XposedHelpers.findClass("com.tencent.assistantv2.st.model.STCommonInfo",loadPackageParam.classLoader);
////                        Field field  = STInfoV2.getDeclaredField("recommendId");
////                        byte[] ba = (byte[])field.get(res);
////                        XposedBridge.log("extractdata2: " + ByteArrayToHexString(ba));
//
//                    }
//                });
//
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistantv2.activity.AppDetailActivityV5",loadPackageParam.classLoader),
//                "i",
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                        XposedBridge.log(new Exception("AppDetailActivityV5.i  zhan"));
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        Object res = (Object) param.getResult();
//
//                        Class STInfoV2 = XposedHelpers.findClass("com.tencent.assistantv2.st.model.STCommonInfo",loadPackageParam.classLoader);
//                        Field field  = STInfoV2.getDeclaredField("recommendId");
//                        byte[] ba = (byte[])field.get(res);
//                        XposedBridge.log("extractdata2: " + ByteArrayToHexString(ba));
//                        field.set(res, null);
//                    }
//                });
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistantv2.st.page.STInfoBuilder",loadPackageParam.classLoader),
//                "buildSTInfo",
//                Context.class,
//                XposedHelpers.findClass("com.tencent.assistant.model.SimpleAppModel",loadPackageParam.classLoader),
//                String.class,
//                        int.class,
//                        String.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                        XposedBridge.log(new Exception(" STInfoBuilder.buildSTInfo  zhan"));
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        Object res = (Object) param.getResult();
//
//                        Class STInfoV2 = XposedHelpers.findClass("com.tencent.assistantv2.st.model.STCommonInfo",loadPackageParam.classLoader);
//                        Field field  = STInfoV2.getDeclaredField("recommendId");
//                        byte[] ba = (byte[])field.get(res);
//                        XposedBridge.log("extractdata3: " + ByteArrayToHexString(ba));
//
//                    }
//                });



//                XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistantv2.st.b",loadPackageParam.classLoader),
//                "b",
//                        byte.class, byte[].class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        XposedBridge.log(new Exception("com.tencent.assistantv2.st.b  zhan"));
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//
//                    }
//                });
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistantv2.st.j",loadPackageParam.classLoader),
//                "a",
//                byte.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        XposedBridge.log(new Exception("com.tencent.assistantv2.st.j  zhan"));
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//
//                    }
//                });
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistantv2.st.business.o",loadPackageParam.classLoader),
//                "a",
//                String.class, int.class, byte.class, byte.class, String.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        XposedBridge.log(new Exception("com.tencent.assistantv2.st.business.o  zhan"));
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//
//                    }
//                });


//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistantv2.activity.AppDetailActivityV5",loadPackageParam.classLoader),
//                "b",
//                String.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        //  XposedBridge.log(new Exception("com.tencent.assistantv2.st.business.y  zhan"));
////                        String p1 = (String) param.args[0];
////                        XposedBridge.log("recommendId: "  +  p1);
////
////                        byte[] pb = Base64.encode(p1.getBytes(), 0);
////                        XposedBridge.log("recommendId pb: "  +  pb);
//
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//
//
//                    }
//                });
//
//
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistantv2.st.business.y",loadPackageParam.classLoader),
//                "a",
//                XposedHelpers.findClass("com.tencent.assistantv2.st.page.STInfoV2",loadPackageParam.classLoader),
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                      //  XposedBridge.log(new Exception("com.tencent.assistantv2.st.business.y  zhan"));
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        Object  result = param.getResult();
//                        Class JceStruct = XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader);
//                        Method toString = XposedHelpers.findMethodBestMatch(JceStruct, "toString");
//                        String res = (String)toString.invoke(result);
//                        XposedBridge.log("res: " + res);
//
////                        Class StatUserAction = XposedHelpers.findClass("com.tencent.assistant.protocol.jce.StatUserAction",loadPackageParam.classLoader);
////                        Field field  = StatUserAction.getDeclaredField("i");
////                        byte[] ba = (byte[])field.get(result);
//
//                    }
//                });
//
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.Global",loadPackageParam.classLoader),
//                "isDev",
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        param.setResult(true);
//                    }
//                });



//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader),
//                "writeTo",
//                XposedHelpers.findClass("com.qq.taf.jce.JceOutputStream",loadPackageParam.classLoader),
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        XposedBridge.log(new Exception("JceStruct writeto  zhan"));
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        param.setResult(true);
//                    }
//                });

        //com.tencent.assistant.module.aw.send
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.module.aw",loadPackageParam.classLoader),
//                "send",
//                int.class,
//                List.class,
//                XposedHelpers.findClass("com.tencent.assistant.protocol.ProtocolDecoder",loadPackageParam.classLoader),
//                boolean.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                        List<Object> list = (List<Object>) param.args[1];
//                        if(list.size() != 0){
//                            Object obj = list.get(0);
//                            XposedBridge.log("request type: " + obj.getClass().getName() + " request size: " + list.size());
//                            XposedBridge.log(new Exception("JceStruct writeto  zhaodashuai"));
//                        }
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        //param.setResult(true);
//                    }
//                });


//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistant.utils.i",loadPackageParam.classLoader),
//                "a",
//                String.class,
//                int.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        String p1 = (String)param.args[0];
//                        XposedBridge.log("string:" + p1);
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        byte[]  result = (byte[])param.getResult();
//                        XposedBridge.log("result: " + result);
//                    }
//                });
////
//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistantv2.component.appdetail.RecommendAppViewV5",loadPackageParam.classLoader),
//                "a",
//                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.RecommendAppInfo",loadPackageParam.classLoader),
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
////                        String p1 = (String)param.args[0];
////                        XposedBridge.log("string:" + p1);
//                        XposedBridge.log("RecommendAppInfo in");
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                        byte[]  result = (byte[])param.getResult();
////                        XposedBridge.log("result: " + result);
//                    }
//                });


//        XposedHelpers.findAndHookMethod(
//                XposedHelpers.findClass("com.tencent.assistantv2.component.appdetail.RecommendAppViewV5",loadPackageParam.classLoader),
//                "a",
//                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.RecommendAppInfo",loadPackageParam.classLoader),
//                XposedHelpers.findClass("com.tencent.assistant.protocol.jce.SimpleAppInfo",loadPackageParam.classLoader),
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//
//                        XposedBridge.log("RecommendAppInfo in2");
//                        Class recommendAppInfo = XposedHelpers.findClass("com.tencent.assistant.protocol.jce.RecommendAppInfo",loadPackageParam.classLoader);
//                        Object p1 = (Object)param.args[0];
//                        Field field  = recommendAppInfo.getDeclaredField("g");
//                        byte[] ba = (byte[])field.get(p1);
//                        XposedBridge.log("extractdata: " + ByteArrayToHexString(ba));
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
////                        byte[]  result = (byte[])param.getResult();
////                        XposedBridge.log("result: " + result);
//                    }
//                });




    }

    private static String ByteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }


}
