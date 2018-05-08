package com.zhaodsh.xposedtool;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class Net extends JceStruct {

    public byte netType = 0;

    public String extNetworkOperator = "";

    public int extNetworkType = 0;

    public byte isWap = 0;

    public Net() {
    }

    @Override
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(netType, 0);
        if (null != extNetworkOperator) {
            jceOutputStream.write(extNetworkOperator, 1);
        }
        jceOutputStream.write(extNetworkType, 2);
        jceOutputStream.write(isWap, 3);
    }

    @Override
    public void readFrom(JceInputStream jceInputStream) {
        netType = jceInputStream.read(netType, 0, true);
        extNetworkOperator = jceInputStream.readString(1, false);
        extNetworkType = jceInputStream.read(extNetworkType, 2, false);
        isWap = jceInputStream.read(isWap, 3, false);
    }

    public Net(byte paramByte1, String paramString, int paramInt, byte paramByte2) {
        netType = paramByte1;
        extNetworkOperator = paramString;
        extNetworkType = paramInt;
        isWap = paramByte2;
    }


}
