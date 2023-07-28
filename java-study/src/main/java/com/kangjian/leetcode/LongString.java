/*
 * Copyright (c) 2020. website www.ziyuele.com
 */

package com.kangjian.leetcode;

public class LongString {


    public static void main(String args[]) throws Exception {
        String s = "abcdeafrgsfbafrgfrg";
       // System.out.println(getRes(s));
        Integer integer = 3;
        System.out.println(((Class<?>) Class.forName("name").getField("TYPE").get(null)).isPrimitive());
    }

    public static String getRes(String s) {
        String tmp = "";
        String res = "";
        int a = 0;
        int b = a;
        while (a<s.length() && b < s.length()) {
            if (tmp.indexOf(s.charAt(b)) == -1) {
                tmp += s.charAt(b);
                b ++;
            } else {
                res = tmp.length() > res.length()? tmp: res;
                tmp = tmp.substring(1, tmp.length());
                a++;
            }
        }
        return res;
    }
}
