package com.example.http_yyb;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

public class httphelper {
    public static class LastError {
        static public int NetIOError = 0;
    }

    public int lastError = -1;// invalid
    public String SERVICE_URL = "";
    private String SERVICE_URL_ALTER = "";

    public String reference = "";

    public String header = "";
    public String url_param = "";
    public String param_entity = "";
    public String paramentityurl = "";

    public ByteArrayEntity be = null;

    public String urlencoded = null;

    public String proxy_ip = "";
    public int proxy_port = 0;

    public String characters = "";


    public class RedirectHandler extends DefaultRedirectHandler {

        @Override
        public boolean isRedirectRequested(HttpResponse response,
                                           HttpContext context) {
            return false;
        }
    }


    public void setProxy(String ip, int port) {
        proxy_ip = ip;
        proxy_port = port;
    }


    public void clearProxy() {
        proxy_ip = null;
        proxy_port = 0;
    }


    public void set_server_url(String url) {
        SERVICE_URL = url;
        SERVICE_URL_ALTER = url;
        reset_request();
    }

    public void reset_request() {
        header = "";
        url_param = "";
        param_entity = "";
        be = null;
    }

    public void add_header(String key, String value) {
        header += (key + "!" + value + "`");
    }

    public void add_urlparam(String key, String value) {
        url_param += (key + "=" + value + "&");
    }

    public void add_paramentity(String key, String value) {
        param_entity += (key + "=" + value + "&");
    }

    public void add_headparamentity(String param) {
        param_entity = (param + param_entity);
    }

    public void add_be(byte[] bb) {
        be = new ByteArrayEntity(bb);
    }

    public String postrequest(String urlpath, String param_byte) {

        String res = requestpost(urlpath, header, url_param, param_entity,
                param_byte);
        if (res != null) {
        }
        return res;
    }

    public String getrequest(String urlpath, String param_byte) {

        String res = requestget(urlpath, header, url_param, param_entity,
                param_byte);
        if (res != null) {
        }
        return res;
    }

    // ==============================================================================================================================

    String requestpost(String url, String header, String params,
                       String paramentity, String param_byte) {

        reference = url + header;
        String result = PostrequestServer(SERVICE_URL + url, params, header,
                paramentity, param_byte);

        if (result != null) {
            // common.logput("zhao", result);

        } else {
            // 如果链接不上，换歌地址尝试
            result = PostrequestServer(SERVICE_URL_ALTER + url, params, header,
                    paramentity, param_byte);
        }

        return result;

    }

    String requestget(String url, String header, String params,
                      String paramentity, String param_byte) {

        String result = GetrequestServer(SERVICE_URL + url, params, header,
                paramentity, param_byte);

        if (result != null) {
            // common.logput("zhao", result);

        } else {
            // 如果链接不上，换歌地址尝试
            result = GetrequestServer(SERVICE_URL_ALTER + url, params, header,
                    paramentity, param_byte);
        }

        return result;

    }


    String GetrequestServer(String url, String params, String header,
                            String paramentity, String param_byte) {
        String httpResponse = null;
        String requestURL = url;
        try {

            if (params != null && params.length() != 0) {
                if (params.endsWith("&")) {
                    params = params.substring(0, params.length() - 1);
                }
                requestURL += params;
            }

            reference = requestURL;
            requestURL = requestURL.replaceAll(" ", "%20");

            HttpGet http = new HttpGet(requestURL);
            HttpParams httpParameters = new BasicHttpParams();
            // httpParameters.setParameter("http.protocol.version",
            // HttpVersion.HTTP_1_0);
            HttpConnectionParams.setConnectionTimeout(httpParameters, 2000);
            HttpConnectionParams.setSoTimeout(httpParameters, 2000);

            // header
            if (header != null && header.length() != 0) {
                String headers[] = header.split("`");
                for (String h : headers) {
                    if (h != null) {
                        String v[] = h.split("!");
                        if (v.length == 2) {
                            http.setHeader(v[0], v[1]);
                        } else {
                            http.setHeader(v[0], "");
                        }

                    }
                }
            }

            // param_entity
            // if(paramentity != null && paramentity.length() != 0){
            // StringEntity httpentity = new StringEntity(paramentity,"utf-8");
            // http.setEntity(httpentity);
            // }
            //
            // //byte entity
            // if(param_byte != null && param_byte.length() != 0){
            // ByteArrayEntity be = new ByteArrayEntity(param_byte.getBytes());
            // http.setEntity(be);
            // }
            //
            DefaultHttpClient client = new DefaultHttpClient(httpParameters);
            RedirectHandler redirectHandler = new RedirectHandler();
            client.setRedirectHandler(redirectHandler);

            if ((proxy_ip != null && proxy_ip.length() != 0) && proxy_port != 0) {
                HttpHost proxy = new HttpHost(proxy_ip, proxy_port);
                client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
            }

            HttpResponse response = client.execute(http);
            int code = response.getStatusLine().getStatusCode();
            if (requestURL.contains("qt=9001")) return "ret ok";
            //if(requestURL.contains("baidu")) return "ret ok";
            //if(requestURL.contains("apk")) return "ret ok";
            if (requestURL.contains("qq")) return "ret ok";

            // common.logput("zhao", "statuscode: " + String.valueOf(code));
            if (200 == code) {
                HttpEntity entity = response.getEntity();
                Header[] hs = (response).getAllHeaders();
                String zip = "";
                String cookie = "";

                for (Header h : hs) {
                    if (h.getName().equals("content-encoding")
                            || h.getName().equals("Content-Encoding")) {
                        zip = h.getValue();
                    }

                    if (h.getName().equals("Set-Cookie")) {
                        cookie = h.getValue();
                    }
                }

                if (url.equalsIgnoreCase("http://m.shouji.baidu.com/")) {
                    return cookie;
                }

                if (zip.equals("gzip")) {
                    InputStream in = entity.getContent();
                    GZIPInputStream gzin = new GZIPInputStream(in);
                    BufferedReader bin = new BufferedReader(
                            new InputStreamReader(gzin, "utf-8"));
                    String retBuf = "";
                    String temp = bin.readLine();
                    if (temp != null) {
                        retBuf += temp;
                        while ((temp = bin.readLine()) != null) {
                            retBuf += temp;
                        }
                    }
                    return retBuf;
                } else {

                    if (requestURL.contains("kuaidi")) {

                        InputStream in = entity.getContent();
                        byte[] byt = toByteArray(in);

                        String ret = new String(byt, "ISO-8859-1");
                        return ret;
                    }

                    if (characters != null && !characters.equals(""))
                        httpResponse = EntityUtils.toString(entity, characters);
                    else
                        httpResponse = EntityUtils.toString(entity);
                    return httpResponse;
                }
            }

        } catch (Exception e) {
            // common.logput("zhao", e.getMessage());
            lastError = LastError.NetIOError;
        }

        return "";

    }


    String PostrequestServer(String url, String params, String header,
                             String paramentity, String param_byte) {
        String httpResponse = null;
        lastError = -1;
        try {
            String requestURL = url;

            if (params != null && params.length() != 0) {

                if (params.endsWith("&")) {
                    params = params.substring(0, params.length() - 1);
                }
                requestURL += params;
            }


            reference = requestURL;
            requestURL = requestURL.replaceAll(" ", "%20");


            HttpPost http = new HttpPost(requestURL);
            HttpParams httpParameters = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParameters, 2000);
            HttpConnectionParams.setSoTimeout(httpParameters, 1000);

            // header
            if (header != null && header.length() != 0) {
                String headers[] = header.split("`");
                for (String h : headers) {
                    if (h != null) {
                        String v[] = h.split("!");
                        if (v.length == 2) {
                            http.setHeader(v[0], v[1]);
                        } else {
                            http.setHeader(v[0], "");
                        }

                    }
                }
            }

            // param_entity
            if (paramentity != null && paramentity.length() != 0) {

                if (paramentity.endsWith("&")) {
                    paramentity = paramentity.substring(0, paramentity.length() - 1);
                }

                StringEntity httpentity = new StringEntity(paramentity, "utf-8");
                http.setEntity(httpentity);
            }

            // //paramentityurl
            // if(paramentityurl != null && paramentityurl.length() != 0){
            // String t = URLEncoder.encode(paramentityurl);
            // StringEntity httpentity = new StringEntity(t,"utf-8");
            // http.setEntity(httpentity);
            // }

            // byte entity
            if (param_byte != null && param_byte.length() != 0) {
                be = new ByteArrayEntity(param_byte.getBytes());
            }

            if (be != null) {
                http.setEntity(be);
            }

            if (this.urlencoded != null && this.urlencoded.length() != 0) {
                ArrayList arraylist = new ArrayList();
                String s4 = URLEncoder.encode(urlencoded, "UTF-8");
                arraylist.add(new BasicNameValuePair("jsonString", s4));
                UrlEncodedFormEntity urlencodedformentity = new UrlEncodedFormEntity(
                        arraylist, "UTF-8");
                http.setEntity(urlencodedformentity);
            }

            DefaultHttpClient client = new DefaultHttpClient(httpParameters);
            RedirectHandler redirectHandler = new RedirectHandler();
            client.setRedirectHandler(redirectHandler);

            if (proxy_ip != null && proxy_ip.length() != 0 && proxy_port != 0) {
                HttpHost proxy = new HttpHost(proxy_ip, proxy_port);
                client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
            }

            HttpResponse response = client.execute(http);

            int code = response.getStatusLine().getStatusCode();
            // common.logput("zhao", "statuscode: " + String.valueOf(code));
            if (200 == code) {
                HttpEntity entity = response.getEntity();
                Header[] hs = (response).getAllHeaders();
                String zip = "";
                String zip2 = "";

                for (Header h : hs) {
                    if (h.getName().equals("content-encoding")
                            || h.getName().equals("Content-Encoding")) {
                        zip = h.getValue();
                    }

                    if (h.getName().equals("content-type")
                            || h.getName().equals("Content-Type")) {
                        zip2 = h.getValue();
                    }

                }
                if (zip.contains("gzip") || zip2.contains("gzip")) {
                    InputStream in = entity.getContent();
                    GZIPInputStream gzin = new GZIPInputStream(in);
                    BufferedReader bin = new BufferedReader(
                            new InputStreamReader(gzin, "utf-8"));
                    String retBuf = "";
                    String temp = bin.readLine();
                    if (temp != null) {
                        retBuf += temp;
                        while ((temp = bin.readLine()) != null) {
                            retBuf += temp;
                        }
                    }
                    return retBuf;
                } else {

                    if (characters != null && !characters.equals(""))
                        httpResponse = EntityUtils.toString(entity, "utf-8");
                    else
                        httpResponse = EntityUtils.toString(entity);

                    return httpResponse;
                }
            }

        } catch (Exception e) {
            lastError = LastError.NetIOError;
            String i = "";
        }

        return "";

    }


    public byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }


    public void down_file(String url, String path, String filenameOuter)
            throws IOException {
        File f = new File(path);
        f.mkdirs();
        String filename = null;
        if (filenameOuter == null) {

            filename = url.substring(url.lastIndexOf("=") + 1);
        } else {
            filename = filenameOuter;
        }

        URL myURL = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();

        InputStream is = conn.getInputStream();
        int fileSize = conn.getContentLength();
        if (fileSize <= 0)
            throw new RuntimeException("file size excepting");
        if (is == null)
            throw new RuntimeException("stream is null");
        String SDFilePath = path + filename;

        FileOutputStream fos = new FileOutputStream(new File(SDFilePath));

        byte buf[] = new byte[128];
        int downLoadFileSize = 0;

        do {
            int numread = is.read(buf);
            if (numread == -1) {
                break;
            }
            fos.write(buf, 0, numread);
            downLoadFileSize += numread;

        } while (true);

        try {
            is.close();
            fos.close();
        } catch (Exception ex) {
            // common.logput("tag", "error: " + ex.getMessage());
        }
        conn.disconnect();
    }


}