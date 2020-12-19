/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.utils;

import java.security.MessageDigest;
import java.util.*;
import java.util.zip.CRC32;

public class EncodeUtil {

    public static String bin2hex(byte[] bytes) {
        StringBuilder ret = new StringBuilder(bytes.length << 1);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(Character.forDigit((bytes[i] >> 4) & 0xf, 16));
            ret.append(Character.forDigit(bytes[i] & 0xf, 16));
        }
        return ret.toString();
    }

    public static byte[] hex2bin(byte[] bsrc) {
        if ((bsrc.length % 2) != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] bret = new byte[bsrc.length / 2];
        for (int n = 0; n < bsrc.length; n += 2) {
            String item = new String(bsrc, n, 2);
            bret[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        bsrc = null;
        return bret;
    }

    public static String md5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes("UTF-8"));
            return bin2hex(bytes).toString();
        } catch (Exception e) {
//            BaseLogger.getMe().error(e, e);
        }
        return null;
    }

    public static String sha1(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] bytes = sha1.digest(str.getBytes("UTF-8"));
            return bin2hex(bytes).toString();
        } catch (Exception e) {
//            BaseLogger.getMe().error(e, e);
        }
            return null;
    }

    public static long crc32(String str) {
        CRC32 checkbytecrc32s = new CRC32();
        checkbytecrc32s.update(str.getBytes());
        return Math.abs((long) checkbytecrc32s.getValue());
    }
    
    
    public static String decodeBase64(String b64string) throws Exception {
        return new String(Base64Util.getMe().decode(b64string), "utf-8");
    }

    public static String encodeBase64(String stringsrc) throws Exception {
        return Base64Util.getMe().encode(stringsrc.getBytes("utf-8"));
    }

    public static byte[] decodeBase64Bytes(String b64bytes) throws Exception {
        return Base64Util.getMe().decode(b64bytes);
    }

    public static String encodeBase64Bytes(byte[] bytessrc) throws Exception {
        return Base64Util.getMe().encode(bytessrc);
    }

    public static String getVerifyLocalByStrArrParam(Map<String, String[]> params, String md5key, Set<String> excludeKeys) {
        if (md5key == null) {
            md5key = "";
        }
        //校验码
        List<String> keys = new ArrayList<String>();
        keys.addAll(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            if (excludeKeys == null || !excludeKeys.contains(key)) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(key).append("=");
                //和getVerifyLocalByMap不一样的地方，value是数组
                for (String str : params.get(key)) {
                    sb.append(str);
                }
            }
        }
        sb.append(md5key);
        String verifyLocal = EncodeUtil.md5(sb.toString()).toLowerCase();
        return verifyLocal;
    }

    public static String getVerifyLocalByMap(Map<String, String> params, String md5key, Set<String> excludeKeys) {
        if (md5key == null) {
            md5key = "";
        }
        //校验码
        List<String> keys = new ArrayList<String>();
        keys.addAll(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            if (excludeKeys == null || !excludeKeys.contains(key)) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(key).append("=");
                sb.append(params.get(key));
            }
        }
        sb.append(md5key);
        String verifyLocal = EncodeUtil.md5(sb.toString()).toLowerCase();
        return verifyLocal;
    }
    
    /**
     * 
     * @param params 
     * @param md5key 
     * @param excludeKeys 生成签名时排除的参数key
     * @param keyKey keyvalue与keyvalue之间的连接符
     * @param keyValue key与value之间的连接符
     * @param paramMd5key 参数与MD5key之间的拼接符
     * @return 
     */
    public static String getVerifyLocalByStrArrParam(Map<String, String[]> params, String md5key, Set<String> excludeKeys, String keyKey, String keyValue, String paramMd5key) {
        if (md5key == null) {
            md5key = "";
        }
        //校验码
        List<String> keys = new ArrayList<String>();
        keys.addAll(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            if (excludeKeys == null || !excludeKeys.contains(key)) {
                if (sb.length() > 0 && !TextUtil.isEmpty(keyKey)) {
                    sb.append(keyKey);
                }
                if (!TextUtil.isEmpty(keyValue)) {
                    sb.append(key).append(keyValue);
                }
                //和getVerifyLocalByMap不一样的地方，value是数组
                for (String str : params.get(key)) {
                    sb.append(str);
                }
            }
        }
        if(!TextUtil.isEmpty(paramMd5key)){
            sb.append(paramMd5key);
        }
        sb.append(md5key);
        String verifyLocal = EncodeUtil.md5(sb.toString()).toLowerCase();
        return verifyLocal;
    }

    /**
     * 
     * @param params
     * @param md5key
     * @param excludeKeys 生成签名时排除的参数key
     * @param keyKey keyvalue与keyvalue之间的连接符
     * @param keyValue key与value之间的连接符
     * @param paramMd5key 参数与MD5key之间的拼接符
     * @return 
     */
    public static String getVerifyLocalByMap(Map<String, String> params, String md5key, Set<String> excludeKeys, String keyKey, String keyValue, String paramMd5key) {
        if (md5key == null) {
            md5key = "";
        }
        //校验码
        List<String> keys = new ArrayList<String>();
        keys.addAll(params.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            if (excludeKeys == null || !excludeKeys.contains(key)) {
                if (sb.length() > 0 && !TextUtil.isEmpty(keyKey)) {
                    sb.append(keyKey);
                }
                if (!TextUtil.isEmpty(keyValue)) {
                    sb.append(key).append(keyValue);
                }
                sb.append(params.get(key));
            }
        }
        if(!TextUtil.isEmpty(paramMd5key)){
            sb.append(paramMd5key);
        }
        sb.append(md5key);
        String verifyLocal = EncodeUtil.md5(sb.toString()).toLowerCase();
        return verifyLocal;
    }
    
}
