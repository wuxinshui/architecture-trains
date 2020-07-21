package com.wxs.hash.redis;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 */
public class HashCircleFactory {

    public static Map<Integer, String> build(List<String> nodes, int virtual) {
        final Map<Integer, String> circleHashMap = new TreeMap<>();

        Random random = new Random(Integer.MAX_VALUE);

        Map<String, Map<Object, Object>> nodeMap = new TreeMap<>();

        int size=nodes.size();

        nodes.forEach(key -> {
            nodeMap.put(key, new TreeMap<>());
            //随机数字，尽可能均匀分布
            int rd = Math.abs(random.nextInt());
            // int hashCode = Math.abs(key.hashCode());
            int hashCode = rehash(key);

            int init = Math.abs(hashCode * rd % Integer.MAX_VALUE % virtual);
            // int init = Math.abs(hashCode * rd % Integer.MAX_VALUE % size);
            // int init = Math.abs(hashCode * rd % Integer.MAX_VALUE);
            // int init = Math.abs(hashCode % Integer.MAX_VALUE % virtual);

            for (int i = 0; i < virtual; i++) {
                circleHashMap.put(init + i, key);
            }
        });

        System.out.println("circle hash:"+circleHashMap);
        return circleHashMap;
    }

    private static int rehash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
}
