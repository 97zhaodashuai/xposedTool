package com.example.http_yyb;


import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Ticket extends JceStruct {
    static byte[] c;
    public byte type = (byte) 0;
    public byte[] value = null;


    public void readFrom(JceInputStream paramJceInputStream) {
        type = paramJceInputStream.read(type, 0, true);
        if (c == null) {
            c = new byte[1];
            c[0] = (byte) 0;
        }
        value = ((byte[]) paramJceInputStream.read(c, 1, true));
    }

    public void writeTo(JceOutputStream paramJceOutputStream) {
        paramJceOutputStream.write(type, 0);
        if (value != null)
            paramJceOutputStream.write(value, 1);
    }
}