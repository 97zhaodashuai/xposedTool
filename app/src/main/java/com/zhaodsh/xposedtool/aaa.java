package com.zhaodsh.xposedtool;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class aaa extends JceStruct {

    public String reserved = "";
    public long version = 0L;

    @Override
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(reserved, 0);
        jceOutputStream.write(version, 1);
    }

    @Override
    public void readFrom(JceInputStream input) {
        reserved = input.readString(0, false);
        version = input.read(version, 1, false);
    }


}
