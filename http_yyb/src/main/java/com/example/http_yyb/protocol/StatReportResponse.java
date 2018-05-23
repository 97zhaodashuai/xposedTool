package com.example.http_yyb.protocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class StatReportResponse extends JceStruct implements Cloneable {
    public int a = 0;

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.a, 0);
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.a = jceInputStream.read(this.a, 0, true);
    }

    public void display(StringBuilder stringBuilder, int i) {
        new JceDisplayer(stringBuilder, i).display(this.a, "ret");
    }

    public void displaySimple(StringBuilder stringBuilder, int i) {
        new JceDisplayer(stringBuilder, i).displaySimple(this.a, false);
    }
}
