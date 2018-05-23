package com.example.http_yyb.factory;

import com.example.http_yyb.protocol.AppChunkDownlaod;
import com.example.http_yyb.protocol.Reporter;
import com.example.http_yyb.protocol.Speed;
import com.example.http_yyb.protocol.StatAppDownlaodWithChunk;
import com.example.http_yyb.protocol.StatReportRequest;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

/**
 * Created by tianhm on 2018/5/23.
 */

public class StatAppDownloadWithChunkFactory {

    public static  StatReportRequest  build(){
        StatReportRequest req = null;

        StatAppDownlaodWithChunk  appdownload = new StatAppDownlaodWithChunk();

        appdownload.a = 12224511;   //appid
        appdownload.b = 68724751;   //apkid
        appdownload.c = 244964;     //revision
        appdownload.d = "123.118.2.109";  //clientIp
        appdownload.g = 5742587;  //fileSize

        appdownload.e = System.currentTimeMillis() - (2000 + (int)(Math.random() * 100));//starTime
        appdownload.f = 2000 - (int)(Math.random() * 100);//costTime

//        jceDisplayer.display(this.h, "chunkList");
        appdownload.h = new ArrayList();
        appdownload.h.add(buildAppChunkDownload());

        appdownload.i = 0; //result
        appdownload.j = 2008; //scene
        appdownload.k = 2001;  //sourceScene

//        jceDisplayer.display(this.l, "extraData");
        appdownload.l = "null|-100";
        appdownload.m = 2;
        appdownload.n = 0;
//        jceDisplayer.display(this.o, "chunkCost");
        appdownload.o = new ArrayList();
        appdownload.o.add(buildSpeed());
        appdownload.p = 0;
        appdownload.q = null;

        appdownload.r = 0;
        appdownload.s = "";
        appdownload.t = 18;
        appdownload.u = "";
        appdownload.v = 0;
        appdownload.w = "06_001";
        appdownload.x = "";
//        jceDisplayer.display(this.y, "reporter");
        appdownload.y = buildReporter();

        appdownload.z = 0;
        appdownload.A = null;
        appdownload.B = 0;
        appdownload.C = "";
        appdownload.D = 0;
        appdownload.E = "";


        return null;
    }


    static  AppChunkDownlaod  buildAppChunkDownload(){

        AppChunkDownlaod  chunkd = new AppChunkDownlaod();

//        jceDisplayer.display(this.a, "downloadUrl");
        chunkd.a = "http://dd.myapp.com/16891/7EFDE5CD42CBA5BCEC586BFEB5DA8373.apk?fsname=com.chinawidth.nansha_2.6_18.apk";
//        jceDisplayer.display(this.b, "finalDownloadUrl");
        chunkd.b = "http://111.202.99.13/dd.myapp.com/16891/7EFDE5CD42CBA5BCEC586BFEB5DA8373.apk?mkey=5b0559946d02508e&f=1b82&c=0&fsname=com.chinawidth.nansha_2.6_18.apk&p=.apk";
//        jceDisplayer.display(this.c, "netType");
        chunkd.c = 1;
//        jceDisplayer.display(this.d, "startPos");
        chunkd.d = 0;
//        jceDisplayer.display(this.e, "fragment");
        chunkd.e = 0;
//        jceDisplayer.display(this.f, "starTime");
        chunkd.f = System.currentTimeMillis() - (2000 + (int)(Math.random() * 100));
//        jceDisplayer.display(this.g, "costTime");
        chunkd.g = 2000 - (int)(Math.random() * 100);
//        jceDisplayer.display(this.h, "jump302");
        chunkd.h = new ArrayList<String>();
        chunkd.h.add(chunkd.b);
//        jceDisplayer.display(this.i, "result");
        chunkd.i = 0;
//        jceDisplayer.display(this.j, "httpCode");
        chunkd.j = 0;
//        jceDisplayer.display(this.k, "extNetworkOperator");
        chunkd.k = "";
//        jceDisplayer.display(this.l, "extNetworkType");
        chunkd.l = -1;
//        jceDisplayer.display(this.m, "isWap");
        chunkd.m = 0;
//        jceDisplayer.display(this.n, "extMsg");
        chunkd.n = null;
//        jceDisplayer.display(this.o, "excpetionName");
        chunkd.o = "";
//        jceDisplayer.display(this.p, "dstIp");
        chunkd.p = "163.177" + (int)(Math.random() * 255 ) + "." + (int)(Math.random() * 255);

        return  chunkd;
    }

    static  Reporter buildReporter(){
        Reporter reporter = new Reporter();
        reporter.a = 0;
        reporter.b = "";
        return reporter;
    }

    static  Speed buildSpeed(){
        Speed speed = new Speed();
        speed.a = 1;
        speed.b = 5742587;
        speed.c =  2000 - (int)(Math.random() * 100);
        speed.d = "";
        speed.e = -1;
        speed.f = 0;
        speed.g = "http://111.202.99.13/dd.myapp.com/16891/7EFDE5CD42CBA5BCEC586BFEB5DA8373.apk?mkey=5b0559946d02508e&f=1b82&c=0&fsname=com.chinawidth.nansha_2.6_18.apk&p=.apk";
//        jceDisplayer.display(this.a, "netType");
//        jceDisplayer.display(this.b, "downSize");
//        jceDisplayer.display(this.c, "costTime");
//        jceDisplayer.display(this.d, "extNetworkOperator");
//        jceDisplayer.display(this.e, "extNetworkType");
//        jceDisplayer.display(this.f, "isWap");
//        jceDisplayer.display(this.g, "finalDownloadUrl");
        return  speed;
    }



}
