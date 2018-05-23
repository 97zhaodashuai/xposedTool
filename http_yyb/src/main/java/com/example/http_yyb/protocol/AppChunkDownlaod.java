package com.example.http_yyb.protocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

import java.util.ArrayList;

public final class AppChunkDownlaod extends JceStruct implements Cloneable {
    static ArrayList q;
    static byte[] r;
    static final /* synthetic */ boolean s = (!AppChunkDownlaod.class.desiredAssertionStatus());
    public String a = "";
    public String b = "";
    public byte c = (byte) 0;
    public long d = 0;
    public long e = 0;
    public long f = 0;
    public long g = 0;
    public ArrayList h = null;
    public byte i = (byte) 0;
    public int j = 0;
    public String k = "";
    public int l = 0;
    public byte m = (byte) 0;
    public byte[] n = null;
    public String o = "";
    public String p = "";

    public byte a() {
        return this.m;
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        if (this.a != null) {
            jceOutputStream.write(this.a, 0);
        }
        if (this.b != null) {
            jceOutputStream.write(this.b, 1);
        }
        jceOutputStream.write(this.c, 2);
        jceOutputStream.write(this.d, 3);
        jceOutputStream.write(this.e, 4);
        jceOutputStream.write(this.f, 5);
        jceOutputStream.write(this.g, 6);
        if (this.h != null) {
            jceOutputStream.write(this.h, 7);
        }
        jceOutputStream.write(this.i, 8);
        jceOutputStream.write(this.j, 9);
        if (this.k != null) {
            jceOutputStream.write(this.k, 10);
        }
        jceOutputStream.write(this.l, 11);
        jceOutputStream.write(this.m, 12);
        if (this.n != null) {
            jceOutputStream.write(this.n, 13);
        }
        if (this.o != null) {
            jceOutputStream.write(this.o, 14);
        }
        if (this.p != null) {
            jceOutputStream.write(this.p, 15);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.a = jceInputStream.readString(0, false);
        this.b = jceInputStream.readString(1, false);
        this.c = jceInputStream.read(this.c, 2, false);
        this.d = jceInputStream.read(this.d, 3, false);
        this.e = jceInputStream.read(this.e, 4, false);
        this.f = jceInputStream.read(this.f, 5, false);
        this.g = jceInputStream.read(this.g, 6, false);
        if (q == null) {
            q = new ArrayList();
            q.add("");
        }
        this.h = (ArrayList) jceInputStream.read(q, 7, false);
        this.i = jceInputStream.read(this.i, 8, false);
        this.j = jceInputStream.read(this.j, 9, false);
        this.k = jceInputStream.readString(10, false);
        this.l = jceInputStream.read(this.l, 11, false);
        this.m = jceInputStream.read(this.m, 12, false);
        if (r == null) {
            r = new byte[1];
            r[0] = (byte) 0;
        }
        this.n = jceInputStream.read(r, 13, false);
        this.o = jceInputStream.readString(14, false);
        this.p = jceInputStream.readString(15, false);
    }

    public void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.a, "downloadUrl");
        jceDisplayer.display(this.b, "finalDownloadUrl");
        jceDisplayer.display(this.c, "netType");
        jceDisplayer.display(this.d, "startPos");
        jceDisplayer.display(this.e, "fragment");
        jceDisplayer.display(this.f, "starTime");
        jceDisplayer.display(this.g, "costTime");
        jceDisplayer.display(this.h, "jump302");
        jceDisplayer.display(this.i, "result");
        jceDisplayer.display(this.j, "httpCode");
        jceDisplayer.display(this.k, "extNetworkOperator");
        jceDisplayer.display(this.l, "extNetworkType");
        jceDisplayer.display(this.m, "isWap");
        jceDisplayer.display(this.n, "extMsg");
        jceDisplayer.display(this.o, "excpetionName");
        jceDisplayer.display(this.p, "dstIp");
    }

    public void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.a, true);
        jceDisplayer.displaySimple(this.b, true);
        jceDisplayer.displaySimple(this.c, true);
        jceDisplayer.displaySimple(this.d, true);
        jceDisplayer.displaySimple(this.e, true);
        jceDisplayer.displaySimple(this.f, true);
        jceDisplayer.displaySimple(this.g, true);
        jceDisplayer.displaySimple(this.h, true);
        jceDisplayer.displaySimple(this.i, true);
        jceDisplayer.displaySimple(this.j, true);
        jceDisplayer.displaySimple(this.k, true);
        jceDisplayer.displaySimple(this.l, true);
        jceDisplayer.displaySimple(this.m, true);
        jceDisplayer.displaySimple(this.n, true);
        jceDisplayer.displaySimple(this.o, true);
        jceDisplayer.displaySimple(this.p, false);
    }
}