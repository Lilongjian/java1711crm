package com.situ.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.CustomerOrder;
import com.situ.crm.mapper.CustomerOrderMapper;
import com.situ.crm.service.ICustomerOrderService;
@Service
public class CustomerOrderServiceImpl implements ICustomerOrderService{
	@Autowired
	private CustomerOrderMapper customerOrderMapper;

	@Override
	public List<CustomerOrder> selectById(Integer id) {
		return customerOrderMapper.selectById(id);
	}

	@Override
	public ServerResponse add(CustomerOrder customerOrder) {
		int count = customerOrderMapper.insert(customerOrder);
		if (count > 0) {
			return ServerResponse.createSUCCESS("添加成功");
		}
		return ServerResponse.createERROR("添加失败");
	}

	@Override
	public ServerResponse delete(Integer id) {
		int count = customerOrderMapper.deleteByPrimaryKey(id);
		if (count > 0) {
			return ServerResponse.createSUCCESS("删除成功");
		}
		return ServerResponse.createERROR("删除失败");
	}

	@Override
	public ServerResponse update(CustomerOrder customerOrder) {
		int count = customerOrderMapper.updateByPrimaryKey(customerOrder);
		if (count > 0) {
			return ServerResponse.createSUCCESS("更新成功");
		}
		return ServerResponse.createERROR("更新失败");
	}

}
