package com.example.http_yyb.protocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

import java.util.ArrayList;

public final class StatReportRequest extends JceStruct{
    static ArrayList b;
    public ArrayList a = null;



    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.a, 0);
    }

    public void readFrom(JceInputStream jceInputStream) {
        if (b == null) {
            b = new ArrayList();
            b.add(new StatReportItem());
        }
        this.a = (ArrayList) jceInputStream.read(b, 0, true);
    }

    public void display(StringBuilder stringBuilder, int i) {
        new JceDisplayer(stringBuilder, i).display(this.a, "statReport");
    }

    public void displaySimple(StringBuilder stringBuilder, int i) {
        new JceDisplayer(stringBuilder, i).displaySimple(this.a, false);
    }
}
