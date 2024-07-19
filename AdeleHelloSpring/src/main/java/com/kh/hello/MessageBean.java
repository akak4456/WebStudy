package com.kh.hello;

public class MessageBean implements MessageBeanI {
    @Override
    public void sayHello(String name) {
        System.out.println(name +"님 안녕하세요~!");
    }
}
