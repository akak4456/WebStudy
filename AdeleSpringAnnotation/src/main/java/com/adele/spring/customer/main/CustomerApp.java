package com.adele.spring.customer.main;

import com.adele.spring.customer.domain.CustomerVO;
import com.adele.spring.customer.service.CustomerService;
import com.adele.spring.customer.service.impl.CustomerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class CustomerApp {
    public static void main(String[] args) {
        String resource = "spring-context.xml";
        ApplicationContext ctx = new GenericXmlApplicationContext(resource);
        CustomerService cService = (CustomerServiceImpl)ctx.getBean("customerService");
        List<CustomerVO> cList = cService.selectList();
        for(CustomerVO customer : cList) {
            System.out.println(customer.toString());
        }
    }
}
