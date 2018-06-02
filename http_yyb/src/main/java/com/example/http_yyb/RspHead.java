package com.example.http_yyb;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

import java.util.ArrayList;

public class RspHead extends JceStruct  {

    static ArrayList j;
    static Ticket k;
    public int a = 0;
    public int b = 0;
    public short c = (short)0;
    public ArrayList d = null;
    public int e = 0;
    public String f = "";
    public String g = "";
    public byte h = (byte)0;
    public Ticket i = null;


    public void display(StringBuilder sb, int paramInt)
    {
        JceDisplayer paramStringBuilder = new JceDisplayer(sb, paramInt);
        paramStringBuilder.display(a, "requestId");
        paramStringBuilder.display(b, "cmdId");
        paramStringBuilder.display(c, "areacode");
        paramStringBuilder.display(d, "ipData");
        paramStringBuilder.display(e, "ret");
        paramStringBuilder.display(f, "phoneGuid");
        paramStringBuilder.display(g, "clientIp");
        paramStringBuilder.display(h, "encryptWithPack");
        paramStringBuilder.display(i, "ticket");
    }

    public void displaySimple(StringBuilder sb, int paramInt)
    {
        JceDisplayer paramStringBuilder = new JceDisplayer(sb, paramInt);
         paramStringBuilder = new JceDisplayer(sb, paramInt);
        paramStringBuilder.displaySimple(a, true);
        paramStringBuilder.displaySimple(b, true);
        paramStringBuilder.displaySimple(c, true);
        paramStringBuilder.displaySimple(d, true);
        paramStringBuilder.displaySimple(e, true);
        paramStringBuilder.displaySimple(f, true);
        paramStringBuilder.displaySimple(g, true);
        paramStringBuilder.displaySimple(h, true);
        paramStringBuilder.displaySimple(i, false);
    }



    public void readFrom(JceInputStream paramJceInputStream)
    {
        a = paramJceInputStream.read(a, 0, true);
        b = paramJceInputStream.read(b, 1, true);
        c = paramJceInputStream.read(c, 2, true);
        if (j == null)
        {
            j = new ArrayList();
            IpData localIPData = new IpData();
            j.add(localIPData);
        }
        d = ((ArrayList)paramJceInputStream.read(j, 3, true));
        e = paramJceInputStream.read(e, 4, true);
        f = paramJceInputStream.readString(5, false);
        g = paramJceInputStream.readString(6, false);
        h = paramJceInputStream.read(h, 7, false);
        if (k == null)
            k = new Ticket();
        i = ((Ticket)paramJceInputStream.read(k, 8, false));
    }

    public void writeTo(JceOutputStream paramJceOutputStream)
    {
        paramJceOutputStream.write(a, 0);
        paramJceOutputStream.write(b, 1);
        paramJceOutputStream.write(c, 2);
        paramJceOutputStream.write(d, 3);
        paramJceOutputStream.write(e, 4);
        if (f != null)
            paramJceOutputStream.write(f, 5);
        if (g != null)
            paramJceOutputStream.write(g, 6);
        paramJceOutputStream.write(h, 7);
        if (i != null)
            paramJceOutputStream.write(i, 8);
    }


}
