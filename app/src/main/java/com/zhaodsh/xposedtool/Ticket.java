package com.zhaodsh.xposedtool;


import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Ticket extends JceStruct
        implements Cloneable {
    static byte[] c;
    public byte a = (byte) 0;
    public byte[] b = null;


    public void readFrom(JceInputStream paramJceInputStream) {
        a = paramJceInputStream.read(a, 0, true);
        if (c == null) {
            c = (byte[]) new byte[1];
            ((byte[]) c)[0] = (byte) 0;
        }
        b = ((byte[]) paramJceInputStream.read(c, 1, true));
    }

    public void writeTo(JceOutputStream paramJceOutputStream) {
        paramJceOutputStream.write(a, 0);
        if(b != null)
            paramJceOutputStream.write(b, 1);
    }
}