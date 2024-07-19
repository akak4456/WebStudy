package com.adele.spring.customer.store.impl;

import com.adele.spring.customer.domain.CustomerVO;
import com.adele.spring.customer.store.CustomerStore;

import java.util.ArrayList;
import java.util.List;

public class CustomerStoreImpl implements CustomerStore {
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
        List<CustomerVO> cList = new ArrayList<>();
        for(int i=0;i<10;i++) {
            CustomerVO customer = new CustomerVO("khuser" + i, i +"용자", i + "", i + "");
            cList.add(customer);
        }
        return cList;
    }

    @Override
    public CustomerVO selectOneById(String customerId) {
        return null;
    }
}
