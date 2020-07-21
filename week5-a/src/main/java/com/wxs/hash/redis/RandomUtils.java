package com.wxs.hash.redis;

import java.util.Random;

public class RandomUtils {

    private RandomUtils() { }

    public static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new Random();

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateString(int length) {
        var sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHAR.charAt(RANDOM.nextInt(ALL_CHAR.length())));
        }
        return sb.toString();
    }

}
