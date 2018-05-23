package com.example.http_yyb.protocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

import java.util.ArrayList;

public final class StatAppDownlaodWithChunk extends JceStruct implements Cloneable {
    static ArrayList F;
    static ArrayList G;
    static byte[] H;
    static Reporter I;
    static byte[] J;
    public byte[] A = null;
    public int B = 0;
    public String C = "";
    public long D = 0;
    public String E = "";
    public long a = 0;
    public long b = 0;
    public long c = 0;
    public String d = "";
    public long e = 0;
    public long f = 0;
    public long g = 0;
    public ArrayList h = null;
    public byte i = (byte) 0;
    public int j = 0;
    public int k = 0;
    public String l = "";
    public byte m = (byte) 0;
    public long n = 0;
    public ArrayList o = null;
    public int p = 0;
    public byte[] q = null;
    public long r = 0;
    public String s = "";
    public int t = 0;
    public String u = "";
    public int v = 0;
    public String w = "";
    public String x = "";
    public Reporter y = null;
    public long z = 0;

    public ArrayList a() {
        return this.h;
    }

    public void a(ArrayList arrayList) {
        this.h = arrayList;
    }

    public void b(ArrayList arrayList) {
        this.o = arrayList;
    }



    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.a, 0);
        jceOutputStream.write(this.b, 1);
        jceOutputStream.write(this.c, 2);
        if (this.d != null) {
            jceOutputStream.write(this.d, 3);
        }
        jceOutputStream.write(this.e, 4);
        jceOutputStream.write(this.f, 5);
        jceOutputStream.write(this.g, 6);
        if (this.h != null) {
            jceOutputStream.write(this.h, 7);
        }
        jceOutputStream.write(this.i, 8);
        jceOutputStream.write(this.j, 9);
        jceOutputStream.write(this.k, 10);
        if (this.l != null) {
            jceOutputStream.write(this.l, 11);
        }
        jceOutputStream.write(this.m, 12);
        jceOutputStream.write(this.n, 13);
        if (this.o != null) {
            jceOutputStream.write(this.o, 14);
        }
        jceOutputStream.write(this.p, 15);
        if (this.q != null) {
            jceOutputStream.write(this.q, 16);
        }
        jceOutputStream.write(this.r, 17);
        if (this.s != null) {
            jceOutputStream.write(this.s, 18);
        }
        jceOutputStream.write(this.t, 19);
        if (this.u != null) {
            jceOutputStream.write(this.u, 20);
        }
        jceOutputStream.write(this.v, 21);
        if (this.w != null) {
            jceOutputStream.write(this.w, 22);
        }
        if (this.x != null) {
            jceOutputStream.write(this.x, 23);
        }
        if (this.y != null) {
            jceOutputStream.write(this.y, 24);
        }
        jceOutputStream.write(this.z, 25);
        if (this.A != null) {
            jceOutputStream.write(this.A, 26);
        }
        jceOutputStream.write(this.B, 27);
        if (this.C != null) {
            jceOutputStream.write(this.C, 28);
        }
        jceOutputStream.write(this.D, 29);
        if (this.E != null) {
            jceOutputStream.write(this.E, 30);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.a = jceInputStream.read(this.a, 0, false);
        this.b = jceInputStream.read(this.b, 1, false);
        this.c = jceInputStream.read(this.c, 2, false);
        this.d = jceInputStream.readString(3, false);
        this.e = jceInputStream.read(this.e, 4, false);
        this.f = jceInputStream.read(this.f, 5, false);
        this.g = jceInputStream.read(this.g, 6, false);
        if (F == null) {
            F = new ArrayList();
            F.add(new AppChunkDownlaod());
        }
        this.h = (ArrayList) jceInputStream.read(F, 7, false);
        this.i = jceInputStream.read(this.i, 8, false);
        this.j = jceInputStream.read(this.j, 9, false);
        this.k = jceInputStream.read(this.k, 10, false);
        this.l = jceInputStream.readString(11, false);
        this.m = jceInputStream.read(this.m, 12, false);
        this.n = jceInputStream.read(this.n, 13, false);
        if (G == null) {
            G = new ArrayList();
            G.add(new Speed());
        }
        this.o = (ArrayList) jceInputStream.read(G, 14, false);
        this.p = jceInputStream.read(this.p, 15, false);
        if (H == null) {
            H = new byte[1];
            H[0] = (byte) 0;
        }
        this.q = jceInputStream.read(H, 16, false);
        this.r = jceInputStream.read(this.r, 17, false);
        this.s = jceInputStream.readString(18, false);
        this.t = jceInputStream.read(this.t, 19, false);
        this.u = jceInputStream.readString(20, false);
        this.v = jceInputStream.read(this.v, 21, false);
        this.w = jceInputStream.readString(22, false);
        this.x = jceInputStream.readString(23, false);
        if (I == null) {
            I = new Reporter();
        }
        this.y = (Reporter) jceInputStream.read(I, 24, false);
        this.z = jceInputStream.read(this.z, 25, false);
        if (J == null) {
            J = new byte[1];
            J[0] = (byte) 0;
        }
        this.A = jceInputStream.read(J, 26, false);
        this.B = jceInputStream.read(this.B, 27, false);
        this.C = jceInputStream.readString(28, false);
        this.D = jceInputStream.read(this.D, 29, false);
        this.E = jceInputStream.readString(30, false);
    }

    public void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.a, "appId");
        jceDisplayer.display(this.b, "apkId");
        jceDisplayer.display(this.c, "revision");
        jceDisplayer.display(this.d, "clientIp");
        jceDisplayer.display(this.e, "starTime");
        jceDisplayer.display(this.f, "costTime");
        jceDisplayer.display(this.g, "fileSize");
        jceDisplayer.display(this.h, "chunkList");
        jceDisplayer.display(this.i, "result");
        jceDisplayer.display(this.j, "scene");
        jceDisplayer.display(this.k, "sourceScene");
        jceDisplayer.display(this.l, "extraData");
        jceDisplayer.display(this.m, "downType");
        jceDisplayer.display(this.n, "searchId");
        jceDisplayer.display(this.o, "chunkCost");
        jceDisplayer.display(this.p, "taskResult");
        jceDisplayer.display(this.q, "extMsg");
        jceDisplayer.display(this.r, "callerUin");
        jceDisplayer.display(this.s, "callerVia");
        jceDisplayer.display(this.t, "versionCode");
        jceDisplayer.display(this.u, "channelId");
        jceDisplayer.display(this.v, "actionFlag");
        jceDisplayer.display(this.w, "slot");
        jceDisplayer.display(this.x, "recommendId");
        jceDisplayer.display(this.y, "reporter");
        jceDisplayer.display(this.z, "categoryId");
        jceDisplayer.display(this.A, "abTestData");
        jceDisplayer.display(this.B, "isCache");
        jceDisplayer.display(this.C, "callFrom");
        jceDisplayer.display(this.D, "pushId");
        jceDisplayer.display(this.E, "pushInfo");
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
        jceDisplayer.displaySimple(this.p, true);
        jceDisplayer.displaySimple(this.q, true);
        jceDisplayer.displaySimple(this.r, true);
        jceDisplayer.displaySimple(this.s, true);
        jceDisplayer.displaySimple(this.t, true);
        jceDisplayer.displaySimple(this.u, true);
        jceDisplayer.displaySimple(this.v, true);
        jceDisplayer.displaySimple(this.w, true);
        jceDisplayer.displaySimple(this.x, true);
        jceDisplayer.displaySimple(this.y, true);
        jceDisplayer.displaySimple(this.z, true);
        jceDisplayer.displaySimple(this.A, true);
        jceDisplayer.displaySimple(this.B, true);
        jceDisplayer.displaySimple(this.C, true);
        jceDisplayer.displaySimple(this.D, true);
        jceDisplayer.displaySimple(this.E, false);
    }
}