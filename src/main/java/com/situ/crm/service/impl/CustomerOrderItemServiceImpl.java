package com.situ.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.crm.entity.OrderItem;
import com.situ.crm.mapper.OrderItemMapper;
import com.situ.crm.service.ICustomerOrderItemService;
@Service
public class CustomerOrderItemServiceImpl implements ICustomerOrderItemService{
	@Autowired
	private OrderItemMapper orderItemMapper;

	@Override
	public List<OrderItem> selectById(Integer id) {
		return orderItemMapper.selectById(id);
	}

}
