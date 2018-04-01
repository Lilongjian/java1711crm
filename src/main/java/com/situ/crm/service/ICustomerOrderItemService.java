package com.situ.crm.service;

import java.util.List;

import com.situ.crm.entity.OrderItem;

public interface ICustomerOrderItemService {

	List<OrderItem> selectById(Integer id);

}
