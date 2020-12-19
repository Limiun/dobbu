/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.utils;

 
public class Base64Util {
    private static Base64Util s_base64Util_instance = null;

    public static Base64Util getMe() {
        if (s_base64Util_instance == null) {
            synchronized (Base64Util.class) {
                if (s_base64Util_instance == null) {
                    s_base64Util_instance = new Base64Util(Base64Util.def_base64_ALPHABET, Base64Util.def_base64_mod);
                }
            }
        }
        return s_base64Util_instance;
    }
    //
    private final static String def_base64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    private final static String def_base64_mod = "=";
    //=============================
    private char[] self_ALPHABET;
    private String self_mod;
    //
    private char char_self_mod;
    private int[] self_toInt;

    public Base64Util(String charmap, String mod) {
    	init(charmap,mod);
    }

    private void init(String charmap, String mod) {
        if ((charmap != null && !charmap.trim().equals("") && (self_ALPHABET == null || !charmap.equals(self_ALPHABET.toString())))
                || (mod != null && !mod.trim().equals("") && !mod.equals(self_mod))) {
            self_ALPHABET = charmap.toCharArray();
            self_mod = mod;
            //
            char_self_mod = self_mod.charAt(0);
            self_toInt = new int[128];
            for (int i = 0; i < self_ALPHABET.length; i++) {
                self_toInt[self_ALPHABET[i]] = i;
            }
        }
    }

    /**
     * Translates the specified byte array into Base64 string.
     *
     * @param buf the byte array (not null)
     * @return the translated Base64 string (not null)
     */
    public String encode(byte[] buf) {
        int size = buf.length;
        char[] ar = new char[((size + 2) / 3) * 4];
        int a = 0;
        int i = 0;
        while (i < size) {
            byte b0 = buf[i++];
            byte b1 = (i < size) ? buf[i++] : 0;
            byte b2 = (i < size) ? buf[i++] : 0;

            int mask = 0x3F;
            ar[a++] = self_ALPHABET[(b0 >> 2) & mask];
            ar[a++] = self_ALPHABET[((b0 << 4) | ((b1 & 0xFF) >> 4)) & mask];
            ar[a++] = self_ALPHABET[((b1 << 2) | ((b2 & 0xFF) >> 6)) & mask];
            ar[a++] = self_ALPHABET[b2 & mask];
        }
        switch (size % 3) {
            case 1:
                ar[--a] = char_self_mod;
            case 2:
                ar[--a] = char_self_mod;
        }
        return new String(ar);
    }

    /**
     * Translates the specified Base64 string into a byte array.
     *
     * @params the Base64 string (not null)
     * @return the byte array (not null)
     */
    public byte[] decode(String src) {
        //增加base decode 容错
        byte[] chars = src.getBytes();
        int chars_len = chars.length;
        int srclen = chars_len;
        int delta = 0;
        for (int i = (chars.length - 1); i >= 0; i--) {
            if (chars[i] == char_self_mod) {
                delta++;
            } else {
                break;
            }
        }
        if (delta > 2 || (srclen % 4) != 0) {
            int caldelta = 4 - ((srclen - delta) % 4);
            if (caldelta <= 2) {
                srclen = srclen - delta + caldelta;
            }
            delta = caldelta;
            if (delta > 2 || (srclen % 4) != 0) {
//                XhhdRuntimeException xruntimeException = new XhhdRuntimeException(String.format("base64Util.decode(delta:%d;mod=%d)('%s') src str is error!!!", delta, (srclen % 4), src));
//                if (coreLibInit.getMe() != null && coreLibInit.getMe().getLoger() != null) {
//                    coreLibInit.getMe().getLoger().logException("base64Util.decode", "base64Util.decode", xruntimeException, null);
//                }
//                throw xruntimeException;
            }
        }
        //
        int buffer_len = srclen * 3 / 4 - delta;
        byte[] buffer = new byte[buffer_len];
        int mask = 0xFF;
        int index = 0;
        int i = 0;
        while (i < srclen) {
            if (i >= chars_len) {
                return buffer;
            }
            int c0 = self_toInt[chars[i++]];
            if (i >= chars_len) {
                return buffer;
            }
            int c1 = self_toInt[chars[i++]];
            buffer[index++] = (byte) (((c0 << 2) | (c1 >> 4)) & mask);
            if (index >= buffer_len || i >= chars_len) {
                return buffer;
            }
            int c2 = self_toInt[chars[i++]];
            buffer[index++] = (byte) (((c1 << 4) | (c2 >> 2)) & mask);
            if (index >= buffer_len || i >= chars_len) {
                return buffer;
            }
            int c3 = self_toInt[chars[i++]];
            buffer[index++] = (byte) (((c2 << 6) | c3) & mask);
        }
        return buffer;
    }

}
