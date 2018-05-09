package com.zhaodsh.xposedtool;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

class Request extends JceStruct {
    static ReqHead c;
    static byte[] d;
    public ReqHead head = null;
    public byte[] body = null;



    public void readFrom(JceInputStream paramJceInputStream) {
        if (c == null)
            c = new ReqHead();
        head = ((ReqHead) paramJceInputStream.read(c, 0, true));
        if (d == null) {
            d = new byte[1];
            d[0] = (byte) 0;
        }
        body = ((byte[]) paramJceInputStream.read(body, 1, false));
    }

    public void writeTo(JceOutputStream paramJceOutputStream) {
        paramJceOutputStream.write(head, 0);
        if (body != null)
            paramJceOutputStream.write(body, 1);
    }
}
