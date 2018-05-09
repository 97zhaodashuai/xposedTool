package com.zhaodsh.xposedtool;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class aaa extends JceStruct {

    static byte[] f;
    public String keyword = "";
    public byte[] contextData = null;
    public int pageSize = 0;
    public int searchScene = 0;
    public long searchId = 0L;


//    public void display(StringBuilder paramStringBuilder, int paramInt)
//    {
//        paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
//        paramStringBuilder.display(a, "keyword");
//        paramStringBuilder.display(b, "contextData");
//        paramStringBuilder.display(c, "pageSize");
//        paramStringBuilder.display(d, "searchScene");
//        paramStringBuilder.display(e, "searchId");
//    }


    @Override
    public void writeTo(JceOutputStream paramJceOutputStream) {
        paramJceOutputStream.write(keyword, 0);
        if (contextData != null)
            paramJceOutputStream.write(contextData, 1);
        paramJceOutputStream.write(pageSize, 2);
        paramJceOutputStream.write(searchScene, 3);
        paramJceOutputStream.write(searchId, 4);
    }

    @Override
    public void readFrom(JceInputStream paramJceInputStream) {
        keyword= paramJceInputStream.readString(0, true);
        if (f == null)
        {
            f = (byte[])new byte[1];
            ((byte[])f)[0] = (byte)0;
        }
        contextData = ((byte[])paramJceInputStream.read(f, 1, false));
        pageSize = paramJceInputStream.read(pageSize, 2, false);
        searchScene = paramJceInputStream.read(searchScene, 3, false);
        searchId = paramJceInputStream.read(searchId, 4, false);
    }


}
