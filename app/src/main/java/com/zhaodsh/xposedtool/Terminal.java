package com.zhaodsh.xposedtool;


import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Terminal extends JceStruct {
    public String imei = "";
    public String macAdress = "";
    public String androidId = "";
    public String androidIdSdCard = "";
    public String imsi = "";


    public void readFrom(JceInputStream paramJceInputStream) {
        imei = paramJceInputStream.readString(0, false);
        macAdress = paramJceInputStream.readString(1, false);
        androidId = paramJceInputStream.readString(2, false);
        androidIdSdCard = paramJceInputStream.readString(3, false);
        imsi = paramJceInputStream.readString(4, false);
    }

    public void writeTo(JceOutputStream paramJceOutputStream) {
        if (imei != null)
            paramJceOutputStream.write(imei, 0);
        if (macAdress != null)
            paramJceOutputStream.write(macAdress, 1);
        if (androidId != null)
            paramJceOutputStream.write(androidId, 2);
        if (androidIdSdCard != null)
            paramJceOutputStream.write(androidIdSdCard, 3);
        if (imsi != null)
            paramJceOutputStream.write(imsi, 4);
    }
}
