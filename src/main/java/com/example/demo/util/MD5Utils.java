package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * @Description： MD5技术加密解密工具类
 * @Author：GF
 * @CreateTime：2020-06-03
 */
@Slf4j
public class MD5Utils {

    /**
     * MD5加码。32位
     *
     * @param inStr
     * @return
     */
    public static String MD5(String inStr) {
        log.info("MD5加密1前：【{}】", inStr);
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        String result = hexValue.toString();
        log.info("MD5加密1后：【{}】", result);
        return result;
    }

    /**
     * 可逆的加密算法
     *
     * @param inStr
     * @return s
     */
    public static String KL(String inStr) {
        log.info("MD5加密2前：【{}】", inStr);
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        log.info("MD5加密2后：【{}】", s);
        return s;
    }

    /**
     * 加密后解密
     *
     * @param inStr
     * @return
     */
    public static String JM(String inStr) {
        log.info("MD5解密前：【{}】", inStr);
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String k = new String(a);
        log.info("MD5解密后：【{}】", k);
        return k;
    }

    /**
     * 测试主函数
     *
     * @param args
     */
    public static void main(String args[]) {
        String s = new String("123456");
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + MD5(s));
        System.out.println("MD5后再加密：" + KL(MD5(s)));
        System.out.println("解密为MD5后的：" + JM(KL(MD5(s))));
    }

}
