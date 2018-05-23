package com.example.http_yyb.protocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Speed extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean h = (!Speed.class.desiredAssertionStatus());
    public byte a = (byte) 0;
    public long b = 0;
    public long c = 0;
    public String d = "";
    public int e = 0;
    public byte f = (byte) 0;
    public String g = "";


    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.a, 0);
        jceOutputStream.write(this.b, 1);
        jceOutputStream.write(this.c, 2);
        if (this.d != null) {
            jceOutputStream.write(this.d, 3);
        }
        jceOutputStream.write(this.e, 4);
        jceOutputStream.write(this.f, 5);
        if (this.g != null) {
            jceOutputStream.write(this.g, 6);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.a = jceInputStream.read(this.a, 0, false);
        this.b = jceInputStream.read(this.b, 1, false);
        this.c = jceInputStream.read(this.c, 2, false);
        this.d = jceInputStream.readString(3, false);
        this.e = jceInputStream.read(this.e, 4, false);
        this.f = jceInputStream.read(this.f, 5, false);
        this.g = jceInputStream.readString(6, false);
    }

    public void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.a, "netType");
        jceDisplayer.display(this.b, "downSize");
        jceDisplayer.display(this.c, "costTime");
        jceDisplayer.display(this.d, "extNetworkOperator");
        jceDisplayer.display(this.e, "extNetworkType");
        jceDisplayer.display(this.f, "isWap");
        jceDisplayer.display(this.g, "finalDownloadUrl");
    }

    public void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.a, true);
        jceDisplayer.displaySimple(this.b, true);
        jceDisplayer.displaySimple(this.c, true);
        jceDisplayer.displaySimple(this.d, true);
        jceDisplayer.displaySimple(this.e, true);
        jceDisplayer.displaySimple(this.f, true);
        jceDisplayer.displaySimple(this.g, false);
    }
}