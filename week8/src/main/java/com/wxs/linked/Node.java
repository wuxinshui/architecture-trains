package com.wxs.linked;

import java.util.Objects;

public class Node {
    private Node next;
    private Node pre;
    private Object obj;

    public Node(Node next, Node pre, Object obj) {
        this.next = next;
        this.pre = pre;
        this.obj = obj;
    }

    public Node() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(obj, node.obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obj);
    }
}
