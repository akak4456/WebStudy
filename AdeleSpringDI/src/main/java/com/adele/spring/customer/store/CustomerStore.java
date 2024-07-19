package com.adele.spring.customer.store;

import com.adele.spring.customer.domain.CustomerVO;

import java.util.List;

public interface CustomerStore {
    int insertCustomer(CustomerVO customer);

    int modifyCustomer(CustomerVO customer);

    int removeCustomer(String customerId);

    List<CustomerVO> selectList();

    CustomerVO selectOneById(String customerId);
}
