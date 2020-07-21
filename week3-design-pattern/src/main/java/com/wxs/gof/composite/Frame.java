package com.wxs.gof.composite;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private String name;

    private List<Frame> frameList;

    public Frame(String name) {
        this.name = name;
        this.frameList = new ArrayList<>();
    }

    public void add(Frame form) {
        frameList.add(form);
    }

    public void remove(Frame form) {
        frameList.remove(form);
    }

    public List<Frame> getFrameList() {
        return frameList;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "name='" + name + '\'' +
                '}';
    }
}
