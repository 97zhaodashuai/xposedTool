package com.example.http_yyb;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

import java.util.ArrayList;

public class IpData extends JceStruct {

    static ArrayList c;
    public int a = 0;
    public ArrayList b = null;

    public void readFrom(JceInputStream paramJceInputStream)
    {
        a = paramJceInputStream.read(a, 0, true);
        if (c == null)
        {
            c = new ArrayList();
            IPDataAddress localIPDataAddress = new IPDataAddress();
            c.add(localIPDataAddress);
        }
        b = ((ArrayList)paramJceInputStream.read(c, 1, true));
    }

    public void writeTo(JceOutputStream paramJceOutputStream)
    {
        paramJceOutputStream.write(a, 0);
        paramJceOutputStream.write(b, 1);
    }

    public void display(StringBuilder sb, int paramInt)
    {
        JceDisplayer paramStringBuilder = new JceDisplayer(sb, paramInt);
        paramStringBuilder.display(a, "type");
        paramStringBuilder.display(b, "addrList");
    }

    public void displaySimple(StringBuilder sb, int paramInt)
    {
        JceDisplayer paramStringBuilder = new JceDisplayer(sb, paramInt);
        paramStringBuilder.displaySimple(a, true);
        paramStringBuilder.displaySimple(b, false);
    }


}
