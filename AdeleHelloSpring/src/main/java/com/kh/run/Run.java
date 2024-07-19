package com.kh.run;

import com.kh.hello.MessageBeanI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Run {
    public static void main(String[] args) {
        String resource = "spring-context.xml";
        ApplicationContext ctx = new GenericXmlApplicationContext(resource);
        MessageBeanI bean = ctx.getBean("messageBean", MessageBeanI.class);
        bean.sayHello("아델2");
    }
}
