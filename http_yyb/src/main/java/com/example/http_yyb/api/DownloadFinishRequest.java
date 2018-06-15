package com.example.http_yyb.api;

import com.example.http_yyb.Net;
import com.example.http_yyb.Request;
import com.example.http_yyb.factory.StatAppDownloadWithChunkFactory;
import com.example.http_yyb.protocol.StatReportRequest;

public class DownloadFinishRequest extends RequestBase {

    public void send(String ip, int port){
        int cmd_id = 24;
        int request_id = 1;
        StatReportRequest reportRequest = StatAppDownloadWithChunkFactory.build();
        Net net = new Net();
        net.netType = 1;
        net.nacMode = 757797134;
        net.ipType = 1;
        net.extNetworkOperator = "";
        net.extNetworkType = -1;
        net.isWap = 0;
        Request reqest = ka(cmd_id, request_id, net, reportRequest);
        httpPost(ip, port, reqest, "com.example.http_yyb.protocol.StatReportResponse");
    }

}
