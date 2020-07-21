package com.wxs.gof.composite;

public class CompositeMain {
    public static void main(String[] args) {
        WindowForm parent = new WindowForm("WINDOW 窗口");
        parent.add(new WindowForm("LOGO图片"));
        parent.add(new WindowForm("登录"));
        parent.add(new WindowForm("注册"));
        parent.add(new WindowForm("FRAME1"));

        Frame frame = new Frame("FRAME1");
        frame.add(new Frame("用户名"));
        frame.add(new Frame("文本框"));
        frame.add(new Frame("密码"));
        frame.add(new Frame("复选框"));
        frame.add(new Frame("记住用户名"));
        frame.add(new Frame("忘记密码"));

        parent.getWindowFormList().forEach(System.out::println);
        frame.getFrameList().forEach(System.out::println);
    }
}
