package com.wxs.gof.composite;

import java.util.ArrayList;
import java.util.List;

public class WindowForm {
    private String name;

    private List<WindowForm> windowFormList;

    public WindowForm(String name) {
        this.name = name;
        this.windowFormList = new ArrayList<>();
    }

    public void add(WindowForm form) {
        windowFormList.add(form);
    }

    public void remove(WindowForm form) {
        windowFormList.remove(form);
    }

    public List<WindowForm> getWindowFormList() {
        return windowFormList;
    }

    @Override
    public String toString() {
        return "WindowForm{" +
                "name='" + name + '\'' +
                '}';
    }
}
