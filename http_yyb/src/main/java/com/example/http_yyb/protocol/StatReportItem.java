package com.example.http_yyb.protocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class StatReportItem extends JceStruct implements Cloneable {
    static byte[] d;
    public byte a = (byte) 0;
    public long b = 1;
    public byte[] c = null;


    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.a, 0);
        jceOutputStream.write(this.b, 1);
        if (this.c != null) {
            jceOutputStream.write(this.c, 2);
        }
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.a = jceInputStream.read(this.a, 0, false);
        this.b = jceInputStream.read(this.b, 1, false);
        if (d == null) {
            d = new byte[1];
            d[0] = (byte) 0;
        }
        this.c = jceInputStream.read(d, 2, false);
    }

    public void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.a, "type");
        jceDisplayer.display(this.b, "version");
        jceDisplayer.display(this.c, "data");
    }

    public void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.a, true);
        jceDisplayer.displaySimple(this.b, true);
        jceDisplayer.displaySimple(this.c, false);
    }
}