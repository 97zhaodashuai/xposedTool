package com.zhaodsh.xposedtool;


import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Terminal extends JceStruct {
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";


    public void readFrom(JceInputStream paramJceInputStream) {
        a = paramJceInputStream.readString(0, false);
        b = paramJceInputStream.readString(1, false);
        c = paramJceInputStream.readString(2, false);
        d = paramJceInputStream.readString(3, false);
        e = paramJceInputStream.readString(4, false);
    }

    public void writeTo(JceOutputStream paramJceOutputStream) {
        if (a != null)
            paramJceOutputStream.write(a, 0);
        if (b != null)
            paramJceOutputStream.write(b, 1);
        if (c != null)
            paramJceOutputStream.write(c, 2);
        if (d != null)
            paramJceOutputStream.write(d, 3);
        if (e != null)
            paramJceOutputStream.write(e, 4);
    }
}
