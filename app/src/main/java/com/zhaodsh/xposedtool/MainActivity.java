package com.zhaodsh.xposedtool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        yybhttp yyb = new yybhttp();
//        yyb._main();

        String.va
        g  ginstance = new g();
        byte[] param = {0x06, 0x00};
        byte[] result = ginstance.encode(param);
        Log.e("zds", ByteArrayToHexString(result));

        byte[] res2 = ginstance.decode(result);
        Log.e("zds", ByteArrayToHexString(res2));

    }

    private static String ByteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }



}
