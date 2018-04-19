package com.zhaodsh.xposedtool;

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
//            XposedHelpers.findClass("com.tencent.assistant.protocol.j",loadPackageParam.classLoader),
//            "a",
//            int.class,
//            XposedHelpers.findClass("com.tencent.assistant.protocol.jce.Request",loadPackageParam.classLoader),
//            List.class,
//            XposedHelpers.findClass("com.tencent.assistant.protocol.ProtocolDecoder",loadPackageParam.classLoader),
//            new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    XposedBridge.log(new Exception("com.tencent.assistant.protocol.j"));
//                }
//
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//
//                }
//            });


        XposedHelpers.findAndHookMethod(
                XposedHelpers.findClass("com.tencent.assistant.module.aw",loadPackageParam.classLoader),
                "send",
                XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader),
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {

                        Class JceStruct = XposedHelpers.findClass("com.qq.taf.jce.JceStruct",loadPackageParam.classLoader);
                        Object param_0 = (Object) param.args[0];
                        Method toDisplaySimpleString = XposedHelpers.findMethodBestMatch(JceStruct, "toDisplaySimpleString", JceStruct);
                        String res = (String)toDisplaySimpleString.invoke(param_0, param_0);

                        XposedBridge.log("request: " + res);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {

                    }
                });

    }

    private static String ByteArrayToHexString(byte[] bytes) {
        final char[] hexArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for ( int j = 0; j < bytes.length; j++ ) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }


}
