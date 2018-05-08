package com.zhaodsh.xposedtool;

import android.util.Log;

import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

public class yybhttp {


    public  void _main() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                aaa bbb = new aaa();
                bbb.version = 4112127;

                int cmd_id_GetSearchHotWords = 9;
                Net net = new Net();
                net.extNetworkOperator = "";
                net.extNetworkType = -1;
                net.netType = 1;
                net.isWap = 0;
                Request req = ka(cmd_id_GetSearchHotWords, 1, net, bbb);
                httpPost(req);
            }
        }).start();


    }


    static public Request ka(int p0,/*cmdid*/ int p1,/*requestid*/ Net p2, JceStruct p3) {
        Request req = new Request();
        ReqHead header = ka(p0, p1, p2);
        req.a = header;
        byte[] tmp = kb(p3);
        req.b = tmp;
        return req;
    }

    static public byte[] kb(JceStruct p0) {
        JceOutputStream v0 = new JceOutputStream();
        String v1 = "utf-8";
        v0.setServerEncoding(v1);
        p0.writeTo(v0);
        byte[] res = v0.toByteArray();
        return res;
    }


    static private ReqHead ka(int p0, int p1, Net p2) {
        byte v0;
        ReqHead head = new ReqHead();
        head.a = p1;   //requestId
        head.b = p0;   //cmdId
        head.f = p2;
        head.l = 1;  // isForeground
        head.j = "1523864357451{72b28484-e282-4965-9b9d-a2b6ba66c0fc}129"; //moloDeviceId
        head.g = 0; //areacode
        head.c = "1314036323888842816";  //phoneGuid
        head.e = "TMA_411/040447&NA/040447&5.1.1_22_1&111_67_14&google_Nexus5&992019&NA&V3"; //qua
        head.h = null;  //terminal
        Ticket tick = new Ticket();
        head.d = tick;  //Ticket
        head.m = 1;  //caller
        return head;
    }


    public static void httpPost(Request request) {

        HttpPost post = null;
        try {

            HttpClient httpClient = new DefaultHttpClient();

            // 设置超时时间
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

            post = new HttpPost("http://101.227.131.50:80");
            // 构造消息头
            post.setHeader("User-Agent", "TMA/4.1.1");
            post.setHeader("X-Online-Host", "ma.3g.qq.com");
            post.setHeader("Host", "101.227.131.50:80");
            post.setHeader("x-tx-host", "ma.3g.qq.com");

            // 构建消息实体
            post.setEntity( new ByteArrayEntity(kb(request)));

            HttpResponse response = httpClient.execute(post);
            int code = response.getStatusLine().getStatusCode();
            Log.e("zhaodsh", code + "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

//    HttpClient httpClient = new DefaultHttpClient();
//
//    this.cmdid = getcmdid(jecstruct)

//    HttpPost post = new HttpPost(url);

//    post.addheader("User-Agent", "");
//    post.addheader(this.e.all);

//    Request req = k.a(cmdid, requestId, net, jecstruct;)
//    req.Reqhead.encryptWithPack = 0;

//    if(req.body.length>256){
//    req.body = zip(req.body);
//    req.Reqhead.encryptWithPack = 1;
//    }
//
//    req.body = encrpty(req.body);  //byte[] v2 = d.a().b(1, v0.b);
//    req.Reqhead.encryptWithPack = 2;

//    post.setentity(new ByteArrayEntity(req)):
//    httpclient.excute(post);



