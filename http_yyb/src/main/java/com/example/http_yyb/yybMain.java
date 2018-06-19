package com.example.http_yyb;

import com.example.http_yyb.api.DownloadFinishRequest;
import java.util.ArrayList;
import java.util.List;

public class yybMain {
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    int i = 0;
                    int max = 1;
                    while (i < max){
                        List<IP>  ipList =  getIPs();
                        for( IP  ip : ipList){
                            download(ip.ip, ip.port);
                            i++;
                            if(i > max){
                                break;
                            }
                        }
                        Thread.sleep(10000);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void download(String ip, int port){
        DownloadFinishRequest  req = new DownloadFinishRequest();
        req.send(ip, port);
    }

    public static class IP{
        public String ip;
        public int	port;
        public String anonymity;
        public String province;
    }
    public static  List<IP> getIPs(){
        ArrayList<IP> result = new ArrayList<IP>();
        int ip = 0;
        httphelper https = new httphelper();
        https.reset_request();
        https.characters = "utf-8";
        String server_url = "http://s.zdaye.com/?api=201806131848573446&px=2";
        https.set_server_url(server_url);
        String ret = https.getrequest("", "");
        if (ret != null && ret.length() != 0) {
            try {
                String[]  ips = ret.split("#");
                for(int i = 0; i < ips.length; i++){
                    String[] temp = ips[i].split(":");
                    IP tip = new IP();
                    tip.ip = temp[0];
                    tip.port =Integer.parseInt(temp[1]);
                    result.add(tip);
                }
            }catch(Exception e){
            }
        }
        return result;
    }



}
