package com.example.http_yyb;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class IPDataAddress extends JceStruct {

    public String a = "";
    public short b = (short)0;


    public void display(StringBuilder sb, int paramInt)
    {
        JceDisplayer paramStringBuilder = new JceDisplayer(sb, paramInt);
        paramStringBuilder.display(a, "ip");
        paramStringBuilder.display(b, "port");
    }

    public void displaySimple(StringBuilder sb, int paramInt)
    {
        JceDisplayer paramStringBuilder = new JceDisplayer(sb, paramInt);
        paramStringBuilder.displaySimple(a, true);
        paramStringBuilder.displaySimple(b, false);
    }


    public void readFrom(JceInputStream paramJceInputStream)
    {
        a = paramJceInputStream.readString(0, true);
        b = paramJceInputStream.read(b, 1, true);
    }

    public void writeTo(JceOutputStream paramJceOutputStream)
    {
        paramJceOutputStream.write(a, 0);
        paramJceOutputStream.write(b, 1);
    }


}
