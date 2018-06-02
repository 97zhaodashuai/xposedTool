package com.example.http_yyb;

import com.example.http_yyb.factory.StatAppDownloadWithChunkFactory;
import com.example.http_yyb.protocol.StatReportRequest;
import com.example.http_yyb.protocol.SuggestRequest;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.ByteArrayBuffer;

import java.io.InputStream;

public class yybMain {

    public  static void main(String[] args) {

        byte[]  a = {0x0c};

        encrpytUtils  eu = new encrpytUtils();
       // a = eu.encode(a);

        a = new byte[]{(byte)0x71,(byte)0x45,(byte)0xEB,(byte)0xE8,(byte)0x62,(byte)0x95,(byte)0xF5,(byte)0xC7};
        //a = eu.decode(a);
        byte[] result_a  = new encrpytUtils().a(a,0);

        System.out.println("zds");

        DownloadRequest();
//        SuggestRequest();

    }

    public static void DownloadRequest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int cmd_id = 4;
                int request_id = 1;

                StatReportRequest reportRequest = StatAppDownloadWithChunkFactory.build();

                Net net = new Net();
                net.netType = 1;
                net.nacMode = 757797134;
                net.ipType = 1;
                net.extNetworkOperator = "";
                net.extNetworkType = -1;
                net.isWap = 0;
                Request reqest = ka(cmd_id, request_id, net, reportRequest);
                httpPost(reqest, "com.example.http_yyb.protocol.StatReportResponse");
            }
        }).start();
    }


    public static void SuggestRequest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int cmd_id = 5;
                int request_id = 48;

                SuggestRequest sr = new SuggestRequest();
                sr.a = "4";

                Net net = new Net();
                net.netType = 1;
                net.nacMode = 757797134;
                net.ipType = 1;
                net.extNetworkOperator = "";
                net.extNetworkType = -1;
                net.isWap = 0;
                Request reqest = ka(cmd_id, request_id, net, sr);
                httpPost(reqest, null);
            }
        }).start();
    }








    static public Request ka(int cmdid, int requestid, Net net, JceStruct request) {
        Request req = new Request();
        req.head = ka(cmdid, requestid, net);
        encrpytUtils enUtils = new encrpytUtils();
        req.body = enUtils.encode(kb(request));
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
        head.encryptWithPack = 2;
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



    public static void httpPost(Request request, String rspClassName) {

        HttpPost post = null;
        try {


            HttpHost proxy = new HttpHost("127.0.0.1",8888);
            RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
            CloseableHttpClient httpclient= HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

            post = new HttpPost("http://101.227.131.50:80");
            // 构造消息头
            post.setHeader("User-Agent", "TMA/4.1.1");
            post.setHeader("X-Online-Host", "ma.3g.qq.com");
            post.setHeader("Host", "101.227.131.50:80");
            post.setHeader("x-tx-host", "ma.3g.qq.com");

            // 构建消息实体
            post.setEntity(new ByteArrayEntity(kb(request)));

            HttpResponse response = httpclient.execute(post);
            int code = response.getStatusLine().getStatusCode();
            System.out.println("code: "  + code);

            HttpEntity v0 = response.getEntity();
            ByteArrayBuffer v1 = new ByteArrayBuffer((int) (v0.getContentLength()));
            InputStream v3 = v0.getContent();
            byte[] v4 = new byte[2048];
            int c = 0;
            while (((c = v3.read(v4)) != -1)) {
                v1.append(v4, 0, c);
            }

            Response resp = ka(v1.buffer());
            RspHead head = resp.a;
            String head_tostring = head.toString();
            System.out.println("head: " + head_tostring);

            resp.b = new encrpytUtils().decode(resp.b);

            if(rspClassName != null && !rspClassName.isEmpty()){
                JceStruct o = (JceStruct)Class.forName(rspClassName).newInstance();
                JceInputStream v2 =  new JceInputStream(resp.b);
                String ch = "utf-8";
                o.readFrom(v2);
                String body_tostring = o.toString();
                System.out.println("body: " + head_tostring);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static  Response ka(byte[] p0){
        byte v1 = 0;
        if (p0 != null && p0.length > 4) {
            JceInputStream v2 =  new JceInputStream(p0);
            String v3 = "utf-8";
            v2.setServerEncoding(v3);
            Response resp = new Response();
            resp.readFrom(v2);
            return resp;
}
        return null;
    }


}
