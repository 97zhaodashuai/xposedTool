package com.example.http_yyb;


import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHead extends JceStruct {

    public int requestId = 0;
    public int cmdId = 0;
    public String phoneGuid = "";
    public Ticket ticket = null;
    public String qua = "";
    public Net net = null;
    public short areacode = (short) 0;
    public Terminal terminal = null;
    public long uin = 0L;
    public String moloDeviceId = "";
    public byte encryptWithPack = (byte) 0;
    public byte isForeground = (byte) 0;
    public byte caller = (byte) 0;
    static Ticket n;
    static Net o;
    static Terminal p;


    public void readFrom(JceInputStream paramJceInputStream) {
        requestId = paramJceInputStream.read(requestId, 0, true);
        cmdId = paramJceInputStream.read(cmdId, 1, true);
        phoneGuid = paramJceInputStream.readString(2, true);
        if (n == null)
            n = new Ticket();
        ticket = ((Ticket) paramJceInputStream.read(n, 3, false));
        qua = paramJceInputStream.readString(4, true);
        if (o == null)
            o = new Net();
        net = ((Net) paramJceInputStream.read(o, 5, true));
        areacode = paramJceInputStream.read(areacode, 6, true);
        if (p == null)
            p = new Terminal();
        terminal = ((Terminal) paramJceInputStream.read(p, 7, false));
        uin = paramJceInputStream.read(uin, 8, false);
        moloDeviceId = paramJceInputStream.readString(9, false);
        encryptWithPack = paramJceInputStream.read(encryptWithPack, 10, false);
        isForeground = paramJceInputStream.read(isForeground, 11, false);
        caller = paramJceInputStream.read(caller, 12, false);
    }


    public void writeTo(JceOutputStream paramJceOutputStream) {
        paramJceOutputStream.write(requestId, 0);
        paramJceOutputStream.write(cmdId, 1);
        paramJceOutputStream.write(phoneGuid, 2);
        if (ticket != null) {
            paramJceOutputStream.write(ticket, 3);
        }
        paramJceOutputStream.write(qua, 4);
        if (net != null) {
            paramJceOutputStream.write(net, 5);
        }

        paramJceOutputStream.write(areacode, 6);
        if (terminal != null) {
            paramJceOutputStream.write(terminal, 7);
        }
        paramJceOutputStream.write(uin, 8);
        if (moloDeviceId != null) {
            paramJceOutputStream.write(moloDeviceId, 9);
        }
        paramJceOutputStream.write(encryptWithPack, 10);
        paramJceOutputStream.write(isForeground, 11);
        paramJceOutputStream.write(caller, 12);
    }
}