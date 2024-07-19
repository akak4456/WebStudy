package com.adele.spring.customer.service.impl;

import com.adele.spring.customer.domain.CustomerVO;
import com.adele.spring.customer.service.CustomerService;
import com.adele.spring.customer.store.CustomerStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerStore cStore;

    public CustomerServiceImpl() {
//        cStore = new CustomerStoreImpl();
    }

    // 2. 생성자를 이용한 의존성 주입
    public CustomerServiceImpl(CustomerStore cStore) {
        this.cStore = cStore;
    }

    // 1. setter를 이용한 의존성 주입
    public void setStore(CustomerStore cStore) {
        this.cStore = cStore;
    }

    @Override
    public int insertCustomer(CustomerVO customer) {
        return 0;
    }

    @Override
    public int modifyCustomer(CustomerVO customer) {
        return 0;
    }

    @Override
    public int removeCustomer(String customerId) {
        return 0;
    }

    @Override
    public List<CustomerVO> selectList() {
        List<CustomerVO> cList = cStore.selectList();
        return cList;
    }

    @Override
    public CustomerVO selectOneById(String customerId) {
        return null;
    }
}
