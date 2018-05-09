package com.zhaodsh.xposedtool;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class Net extends JceStruct {

    public byte netType = 0;
    public int nacMode = 0;
    public byte ipType = 2;
    public String extNetworkOperator = "";
    public int extNetworkType = 0;
    public byte isWap = 0;



    public Net() {
    }

    @Override
    public void writeTo(JceOutputStream paramJceOutputStream) {
        paramJceOutputStream.write(netType, 0);
        paramJceOutputStream.write(nacMode, 1);
        paramJceOutputStream.write(ipType, 2);
        if (extNetworkOperator != null)
            paramJceOutputStream.write(extNetworkOperator, 3);
        paramJceOutputStream.write(extNetworkType, 4);
        paramJceOutputStream.write(isWap, 5);



    }

    @Override
    public void readFrom(JceInputStream paramJceInputStream) {

        netType = paramJceInputStream.read(netType, 0, true);
        nacMode = paramJceInputStream.read(nacMode, 1, true);
        ipType = paramJceInputStream.read(ipType, 2, false);
        extNetworkOperator = paramJceInputStream.readString(3, false);
        extNetworkType = paramJceInputStream.read(extNetworkType, 4, false);
        isWap = paramJceInputStream.read(isWap, 5, false);



    }


}
