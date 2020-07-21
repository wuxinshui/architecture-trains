package com.wxs.hash.redis;

import java.util.*;

/**
 * 问题背景
 * 用你熟悉的编程语言实现一致性 hash 算法。
 * 编写测试用例测试这个算法，测试 100 万 KV 数据，10 个服务器节点的情况下，
 * 计算这些 KV 数据在服务器上分布数量的标准差，以评估算法的存储负载不均衡性。
 *
 * 解决什么问题
 *
 * 核心痛点
 *
 * 1.构建环
 * 2.构建服务器节点的分布
 * 3.实现put\query
 */
public class HashCircleMain {

    private static final Map<Object, Object> circleHashMap = new TreeMap<>();
    // private static final Map<Object, Object> nodeMap = new TreeMap<>();


    public boolean put(String key, Object value) {
        Object result = circleHashMap.put(key, value);

        return Objects.nonNull(result);
    }


    public static void main(String[] args) {
        List<String> ipAddressList = List.of("10.22.34.91", "10.22.34.92", "10.22.34.93", "10.22.34.94", "10.22.34.95",
                "10.22.34.96", "10.22.34.97", "10.22.34.98", "10.22.34.99", "10.22.34.10");
        Random random = new Random(Integer.MAX_VALUE);

        Map<String, Map<Object, Object>> nodeMap = new TreeMap<>();

        ipAddressList.forEach(key -> {
            nodeMap.put(key, new TreeMap<>());
            int rd = Math.abs(random.nextInt());
            // System.out.print(rd + "==" + key + " -- ");
            int hashCode = Math.abs(key.hashCode());
            // System.out.print(hashCode + " -- ");
            // System.out.print(hashCode % Integer.MAX_VALUE + " -- ");
            // System.out.print(hashCode % Integer.MAX_VALUE % 256 + " -- ");
            // System.out.print(hashCode * 1024 % Integer.MAX_VALUE + " -- ");
            // System.out.print(hashCode * rd % Integer.MAX_VALUE);
            // System.out.println();

            int init = Math.abs(hashCode * rd % Integer.MAX_VALUE);


            for (int i = 0; i < 100; i++) {
                circleHashMap.put(init + i, key);
            }
            // circleHashMap.put(init, nodeMap);
        });

        System.out.println(circleHashMap);
    }


}
