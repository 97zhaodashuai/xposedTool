package com.example.http_yyb.protocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Reporter extends JceStruct implements Cloneable {
    public int a = 0;
    public String b = "";

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.a, 0);
        jceOutputStream.write(this.b, 1);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.a = jceInputStream.read(this.a, 0, true);
        this.b = jceInputStream.readString(1, true);
    }

    public void display(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.a, "accountType");
        jceDisplayer.display(this.b, "userId");
    }

    public void displaySimple(StringBuilder stringBuilder, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.a, true);
        jceDisplayer.displaySimple(this.b, false);
    }
}