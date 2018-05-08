package com.zhaodsh.xposedtool;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

class Request extends JceStruct {
    static ReqHead c;
    static byte[] d;
    public ReqHead a = null;
    public byte[] b = null;


    public Object clone() {
        Object localObject1 = null;
        try {
            Object localObject2 = super.clone();
            localObject1 = localObject2;
            return localObject1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new AssertionError();
    }


    public void readFrom(JceInputStream paramJceInputStream) {
        if (c == null)
            c = new ReqHead();
        a = ((ReqHead) paramJceInputStream.read(c, 0, true));
        if (d == null) {
            d = (byte[]) new byte[1];
            ((byte[]) d)[0] = (byte) 0;
        }
        b = ((byte[]) paramJceInputStream.read(d, 1, false));
    }

    public void writeTo(JceOutputStream paramJceOutputStream) {
        paramJceOutputStream.write(a, 0);
        if (b != null)
            paramJceOutputStream.write(b, 1);
    }
}
