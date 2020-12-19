package com.example.demo.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

public class ParamsUtil {

	
    public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";
    private static final String URL_PARAM_CONNECT_FLAG = "&";
    private static final String EMPTY = "";
    
    
    public static String getUrl(Map<String, String> map) {
        if (null == map || map.isEmpty()) {
            return (EMPTY);
        }
        StringBuilder url = new StringBuilder();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            if (map.containsKey(key)) {
                String val = map.get(key);
                String str = (val != null) ? val : EMPTY;
                try {
                    str = URLEncoder.encode(str, URL_PARAM_DECODECHARSET_UTF8);
                } catch (UnsupportedEncodingException e) {
//                    log.error(e, e);
                }
                url.append(key).append("=").append(str).append(URL_PARAM_CONNECT_FLAG);
            }
        }
        String strURLParam = url.toString();
        if (strURLParam.endsWith(URL_PARAM_CONNECT_FLAG)) {
            strURLParam = strURLParam.substring(0, strURLParam.length() - 1);
        }
        return (strURLParam);
    }
    
    
    
    public static int getSecTime(String agent) {
        //TODO  正式上线环境里有效时间应该不能超过3~5分钟
        //30天
        return 30 * 24 * 60 * 60;
//        return 5 * 60;
//        return 15 * 60;
    }
}