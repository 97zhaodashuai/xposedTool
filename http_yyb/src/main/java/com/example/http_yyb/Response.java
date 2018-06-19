package com.example.http_yyb;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class Response extends JceStruct {

    static RspHead c;
    static byte[] d;
    public RspHead a = null;
    public byte[] b = null;


    public void display(StringBuilder sb, int paramInt)
    {
        JceDisplayer paramStringBuilder = new JceDisplayer(sb, paramInt);
        paramStringBuilder.display(a, "head");
        paramStringBuilder.display(b, "body");
    }

    public void displaySimple(StringBuilder sb, int paramInt)
    {
        JceDisplayer paramStringBuilder = new JceDisplayer(sb, paramInt);
        paramStringBuilder.displaySimple(a, true);
        paramStringBuilder.displaySimple(b, false);
    }


    public void readFrom(JceInputStream paramJceInputStream)
    {
        if (c == null){
            c = new RspHead();
        }
        a = ((RspHead)paramJceInputStream.read(c, 0, true));
        if (d == null) {
            d = new byte[1];
            d[0] = (byte)0;
        }
        b = (byte[])paramJceInputStream.read(d, 1, true);
    }

    public void writeTo(JceOutputStream paramJceOutputStream)
    {
        paramJceOutputStream.write(a, 0);
        paramJceOutputStream.write(b, 1);
    }

}
