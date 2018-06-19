package com.example.http_yyb.api;

import com.example.http_yyb.Net;
import com.example.http_yyb.Phone;
import com.example.http_yyb.ReqHead;
import com.example.http_yyb.Request;
import com.example.http_yyb.Response;
import com.example.http_yyb.RspHead;
import com.example.http_yyb.Terminal;
import com.example.http_yyb.Ticket;
import com.example.http_yyb.encrpytUtils;
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
import org.apache.http.util.ByteArrayBuffer;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.Deflater;

public class RequestBase {

    public Request ka(int cmdid, int requestid, Net net, JceStruct request) {
        Request req = new Request();
        req.head = ka(cmdid, requestid, net);
        req.body = kb(request);
        if (req.body.length > 256) {
            req.body = ax_a(req.body);
            req.head.encryptWithPack = (byte) (req.head.encryptWithPack | ((byte) 0x01));
        }
        encrpytUtils enUtils = new encrpytUtils();
        req.body = enUtils.encode(req.body);
        req.head.encryptWithPack = (byte) (req.head.encryptWithPack | ((byte) 0x02));

        return req;
    }

//    private ReqHead ka(int cmdId, int requestId, Net net) {
//        ReqHead head = new ReqHead();
//        head.requestId = requestId;
//        head.cmdId = cmdId;
//        head.phoneGuid = "1314036323888842816";
//
//        Ticket ticket = new Ticket();
//        ticket.type = 0;
//        ticket.value = new byte[0];
//        head.ticket = ticket;
//
//        head.qua = "TMA_411/040447&NA/040447&5.1.1_22_1&111_67_14&google_Nexus5&992019&NA&V3";
//        head.net = net;
//        head.areacode = 1796;
//
//        Terminal t = new Terminal();
//        t.imei = "359250052035365";  //
//        t.macAdress = "48:59:29:f2:73:37";
//        t.androidId = "9b6a3d46e13c2ecd";
//        t.androidIdSdCard = "9b6a3d46e13c2ecd";
//        t.imsi = ""; //Phone.getIMSI();
//
//        head.terminal = null;
//        head.uin = 0;
//        head.moloDeviceId = "1523864357451{72b28484-e282-4965-9b9d-a2b6ba66c0fc}129";
//        head.encryptWithPack = 0;
//        head.isForeground = 1;
//        head.caller = 1;
//
//        System.out.print("head: " + head.toString());
//        return head;
//    }

//
    private ReqHead ka(int cmdId, int requestId, Net net) {
        ReqHead head = new ReqHead();
        head.requestId = requestId;
        head.cmdId = cmdId;
        head.phoneGuid = Phone.getPhoneGUID();//"1314036323888842816";

        Ticket ticket = new Ticket();
        ticket.type = 0;
        ticket.value = new byte[0];
        head.ticket = ticket;

        head.qua = Phone.getQua(); //"TMA_411/040447&NA/040447&5.1.1_22_1&111_67_14&google_Nexus5&992019&NA&V3";
        head.net = net;
        head.areacode = 1796;

        Terminal t = new Terminal();
        t.imei = Phone.getIMEI(); //"359250052035365";  //
        t.macAdress = Phone.getMac(); //"48:59:29:f2:73:37";
        t.androidId = Phone.getAndroidId(); //"9b6a3d46e13c2ecd";
        t.androidIdSdCard = Phone.getAndroidId(); //"9b6a3d46e13c2ecd";
        t.imsi = Phone.getIMSI();

        head.terminal = null;
        head.uin = 0;
        head.moloDeviceId = Phone.getmoloDeviceId();//"1523864357451{72b28484-e282-4965-9b9d-a2b6ba66c0fc}129";
        head.encryptWithPack = 0;
        head.isForeground = 1;
        head.caller = 1;

        System.out.print("head: " + head.toString());
        return head;
    }


    public byte[] kb(JceStruct p0) {
        JceOutputStream v0 = new JceOutputStream();
        String v1 = "utf-8";
        v0.setServerEncoding(v1);
        p0.writeTo(v0);
        byte[] res = v0.toByteArray();
        return res;
    }


    public void httpPost(String ip, int port, Request request, String rspClassName) {

        HttpPost post = null;
        try {
            ip = "171.10.31.73";
            port = 8080;

            HttpHost proxy = new HttpHost(ip, port);
            RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
            CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

//            HttpClient httpclient = new DefaultHttpClient();

            post = new HttpPost("http://101.227.131.50:80");
            // 构造消息头
            post.setHeader("User-Agent", "TMA/4.1.1");
            post.setHeader("X-Online-Host", "ma.3g.qq.com");
            post.setHeader("Host", "101.227.131.50:80");
            post.setHeader("x-tx-host", "ma.3g.qq.com");
//            post.setHeader("Cls", rspClassName);
            // 构建消息实体
            post.setEntity(new ByteArrayEntity(kb(request)));

            HttpResponse response = httpclient.execute(post);
            int code = response.getStatusLine().getStatusCode();
            System.out.println("code: " + code);

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
            resp.b = new encrpytUtils().decode(resp.b);
            if (rspClassName != null && !rspClassName.isEmpty()) {
                JceStruct o = (JceStruct) Class.forName(rspClassName).newInstance();
                JceInputStream v2 = new JceInputStream(resp.b);
                String ch = "utf-8";
                o.readFrom(v2);
                String body_tostring = o.toString();
                System.out.println("body: " + head_tostring);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    Response ka(byte[] p0) {
        if (p0 != null && p0.length > 4) {
            JceInputStream v2 = new JceInputStream(p0);
            String v3 = "utf-8";
            v2.setServerEncoding(v3);
            Response resp = new Response();
            resp.readFrom(v2);
            return resp;
        }
        return null;
    }

    private void printByteArray(String tag, byte[] bytes) {
        System.out.print(tag + ": " + ByteArrayToHexString(bytes));
    }

    private static String ByteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }


    public byte[] ax_a(byte[] p0) {
        Deflater v3 = new Deflater();
        ByteArrayOutputStream v1 = new ByteArrayOutputStream(p0.length);
        v3.setLevel(9);
        v3.setInput(p0);
        v3.finish();
        byte[] v0 = new byte[1024];
        while ((!v3.finished())) {
            byte v4 = 0;
            v1.write(v0, v4, v3.deflate(v0));
        }
        v3.end();
        if (v1 != null) {
            try {
                v1.close();
            } catch (Exception e) {
            }
        }
        return v1.toByteArray();
    }


}
