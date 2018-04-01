package com.situ.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.CustomerContact;
import com.situ.crm.entity.CustomerLinkman;
import com.situ.crm.mapper.CustomerContactMapper;
import com.situ.crm.service.ICustomerContactService;

import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
@Service
public class CustomerContactServiceImpl implements ICustomerContactService{
	@Autowired
	private CustomerContactMapper customerContactMapper;

	@Override
	public List<CustomerContact> selectById(Integer id) {
		return customerContactMapper.selectById(id);
	}

	@Override
	public ServerResponse add(CustomerContact customerContact) {
		int count = customerContactMapper.insert(customerContact);
		if (count > 0) {
			return ServerResponse.createSUCCESS("添加成功");
		}
		return ServerResponse.createERROR("添加失败");
	}

	@Override
	public ServerResponse delete(Integer id) {
	    int count = customerContactMapper.deleteByPrimaryKey(id);
	    if (count > 0) {
			return ServerResponse.createSUCCESS("删除成功");
		}
		return ServerResponse.createERROR("删除失败");
	}

	@Override
	public ServerResponse update(CustomerContact customerContact) {
	 	int count = customerContactMapper.updateByPrimaryKey(customerContact);
	 	if (count > 0) {
			return ServerResponse.createSUCCESS("更新成功");
		}
		return ServerResponse.createERROR("更新失败");
	}

}
