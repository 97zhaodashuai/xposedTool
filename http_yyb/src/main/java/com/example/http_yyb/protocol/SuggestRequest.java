package com.example.http_yyb.protocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SuggestRequest extends JceStruct implements Cloneable {
    public String a = "";

    public void readFrom(JceInputStream paramJceInputStream)
    {
        a = paramJceInputStream.readString(0, true);
    }

    public void writeTo(JceOutputStream paramJceOutputStream)
    {
        paramJceOutputStream.write(a, 0);
    }
}
