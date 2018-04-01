package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.CustomerOrder;

public interface ICustomerOrderService {

	List<CustomerOrder> selectById(Integer id);

	ServerResponse add(CustomerOrder customerOrder);

	ServerResponse delete(Integer id);

	ServerResponse update(CustomerOrder customerOrder);

}
