package com.example.http_yyb;

import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

public class yybMain {

    public  static void main(String[] args) {

//        System.out.println("hello world");

        new Thread(new Runnable() {
            @Override
            public void run() {
                int cmd_id = 4;
                int request_id = 1;

                //SearchRequest
//                aaa req = new aaa();
//                req.keyword = "桌面";
//                req.contextData = new byte[0];
//                req.pageSize = 10;
//                req.searchScene = 200702;
//                req.searchId = 0;
//
//                Net net = new Net();
//                net.netType = 1;
//                net.nacMode = 757797134;
//                net.ipType = 1;
//                net.extNetworkOperator = "";
//                net.extNetworkType = -1;
//                net.isWap = 0;
//
//                Request reqest = ka(cmd_id, request_id, net, req);
//                httpPost(reqest);
            }
        }).start();


    }


    static public Request ka(int cmdid, int requestid, Net net, JceStruct request) {
        Request req = new Request();
        req.head = ka(cmdid, requestid, net);
        req.body = kb(request);
        return req;
    }

    static private ReqHead ka(int cmdId, int requestId, Net net) {
        ReqHead head = new ReqHead();
        head.requestId = requestId;
        head.cmdId = cmdId;
        head.phoneGuid = "1314036323888842816";

        Ticket ticket = new Ticket();
        ticket.type = 0;
        ticket.value = new byte[0];
        head.ticket = ticket;

        head.qua = "TMA_411/040447&NA/040447&5.1.1_22_1&111_67_14&google_Nexus5&992019&NA&V3";
        head.net = net;
        head.areacode = 1796;

        head.terminal = null;
        head.uin = 0;
        head.moloDeviceId = "1523864357451{72b28484-e282-4965-9b9d-a2b6ba66c0fc}129";
        head.encryptWithPack = 0;
        head.isForeground = 1;
        head.caller = 1;
        return head;
    }



    static public byte[] kb(JceStruct p0) {
        JceOutputStream v0 = new JceOutputStream();
        String v1 = "utf-8";
        v0.setServerEncoding(v1);
        p0.writeTo(v0);
        byte[] res = v0.toByteArray();
        return res;
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
            post.setEntity(new ByteArrayEntity(kb(request)));

            HttpResponse response = httpClient.execute(post);
            int code = response.getStatusLine().getStatusCode();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
