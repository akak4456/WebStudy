package com.adele.spring.customer.service.impl;

import com.adele.spring.customer.domain.CustomerVO;
import com.adele.spring.customer.service.CustomerService;
import com.adele.spring.customer.store.CustomerStore;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerStore cStore;

    public CustomerServiceImpl() {
//        cStore = new CustomerStoreImpl();
    }

    public CustomerServiceImpl(CustomerStore cStore) {
        this.cStore = cStore;
    }

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
