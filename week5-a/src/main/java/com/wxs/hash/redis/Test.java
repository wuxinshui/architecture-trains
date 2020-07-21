package com.wxs.hash.redis;

import java.util.*;

public class Test {
    private static final List<String> list = new ArrayList<>();

    private static final Set<String> sets = new TreeSet<>();

    public static void main(String[] args) {
        List<String> ipAddressList = List.of("10.22.34.91", "10.22.34.92", "10.22.34.93", "10.22.34.94", "10.22.34.95",
                "10.22.34.96", "10.22.34.97", "10.22.34.98", "10.22.34.99", "10.22.34.10");
        Map<Integer, String> circle = HashCircleFactory.build(ipAddressList, 32);

        list.stream().forEach(str -> {
            int hashCode = Math.abs(str.hashCode());
            int mo=hashCode%ipAddressList.size();
            Integer rightKey = circle.keySet().stream().filter(key -> mo <= key).findFirst().get();

            String rightValue = circle.get(rightKey);
            sets.add(rightValue);
            // System.out.println("str hashCode mo:" + mo+"  rightKey:" + rightKey+" rightValue:" + rightValue);
        });


        System.out.println(sets);

    }

    static {
        for (int i = 0; i < 10000000; i++) {
            String str = RandomUtils.generateString(10);
            list.add(str);
        }
    }


}
