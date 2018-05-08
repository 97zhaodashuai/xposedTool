package com.zhaodsh.xposedtool;


import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHead extends JceStruct {
    static Ticket n;
    static Net o;
    static Terminal p;
    public int a = 0;
    public int b = 0;
    public String c = "";
    public Ticket d = null;
    public String e = "";
    public Net f = null;
    public short g = (short) 0;
    public Terminal h = null;
    public long i = 0L;
    public String j = "";
    public byte k = (byte) 0;
    public byte l = (byte) 0;
    public byte m = (byte) 0;

    public void display(StringBuilder paramStringBuilder, int paramInt)
    {
//        paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
//        paramStringBuilder.display(a, "requestId");
//        paramStringBuilder.display(b, "cmdId");
//        paramStringBuilder.display(c, "phoneGuid");
//        paramStringBuilder.display(d, "ticket");
//        paramStringBuilder.display(e, "qua");
//        paramStringBuilder.display(f, "net");
//        paramStringBuilder.display(g, "areacode");
//        paramStringBuilder.display(h, "terminal");
//        paramStringBuilder.display(i, "uin");
//        paramStringBuilder.display(j, "moloDeviceId");
//        paramStringBuilder.display(k, "encryptWithPack");
//        paramStringBuilder.display(l, "isForeground");
//        paramStringBuilder.display(m, "caller");
    }


    public void readFrom(JceInputStream paramJceInputStream) {
        a = paramJceInputStream.read(a, 0, true);
        b = paramJceInputStream.read(b, 1, true);
        c = paramJceInputStream.readString(2, true);
        if (n == null)
            n = new Ticket();
        d = ((Ticket) paramJceInputStream.read(n, 3, false));
        e = paramJceInputStream.readString(4, true);
        if (o == null)
            o = new Net();
        f = ((Net) paramJceInputStream.read(o, 5, true));
        g = paramJceInputStream.read(g, 6, true);
        if (p == null)
            p = new Terminal();
        h = ((Terminal) paramJceInputStream.read(p, 7, false));
        i = paramJceInputStream.read(i, 8, false);
        j = paramJceInputStream.readString(9, false);
        k = paramJceInputStream.read(k, 10, false);
        l = paramJceInputStream.read(l, 11, false);
        m = paramJceInputStream.read(m, 12, false);
    }


    public void writeTo(JceOutputStream paramJceOutputStream) {
        paramJceOutputStream.write(a, 0);
        paramJceOutputStream.write(b, 1);
        paramJceOutputStream.write(c, 2);
        if (d != null)
            paramJceOutputStream.write(d, 3);
        paramJceOutputStream.write(e, 4);
        paramJceOutputStream.write(f, 5);
        paramJceOutputStream.write(g, 6);
        if (h != null)
            paramJceOutputStream.write(h, 7);
        paramJceOutputStream.write(i, 8);
        if (j != null)
            paramJceOutputStream.write(j, 9);
        paramJceOutputStream.write(k, 10);
        paramJceOutputStream.write(l, 11);
        paramJceOutputStream.write(m, 12);
    }
}