package org.example.demo.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class IpUtil {

    static final String netUrl = "http://2018.ip138.com/ic.asp";

    /**
     * 获得内网IP
     *
     * @return 内网IP
     */
    public static String getIntranetIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获得外网IP
     *
     * @return 外网IP
     */
    public static String getInternetIp() {
        try {
            //如果请求超时 ,请查看查询本机IP网站 是否更换
            URL url = new URL(netUrl);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String s = "";
            StringBuffer sb = new StringBuffer("");
            String webContent = "";
            while ((s = br.readLine()) != null) {
                sb.append(s + "\r\n");
            }
            br.close();
            webContent = sb.toString();
            int start = webContent.indexOf("[")+1;
            int end = webContent.indexOf("]");
            webContent = webContent.substring(start,end);
            return webContent;

        } catch (Exception e) {
            System.err.println("获取IP发生错误");
            e.printStackTrace();
            return "error";
        }
    }
}
