package com.wxs.linked;

import java.util.LinkedList;
import java.util.Objects;

public class LinkedDuplicated {
    public static void main(String[] args) {
        int m = 10;
        int n = 10;
        LinkedList<Node> linkedListM = new LinkedList<>();
        LinkedList<Node> linkedListN = new LinkedList<>();

        linkedListM.forEach(M -> {
            linkedListN.forEach(N -> {
                if (Objects.equals(M, N)) {
                    return;
                }
            });
        });


    }
}
