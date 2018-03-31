package com.situ.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.CustomerLinkman;
import com.situ.crm.mapper.CustomerLinkmanMapper;
import com.situ.crm.service.ICustomerLinkManService;
@Service
public class CustomerLinkManServiceImpl implements ICustomerLinkManService{
	@Autowired
	private CustomerLinkmanMapper customerLinkmanMapper;

	@Override
	public List<CustomerLinkman> selectById(Integer id) {
		return customerLinkmanMapper.selectById(id);
	}

	@Override
	public ServerResponse add(CustomerLinkman customerLinkman) {
		int count = customerLinkmanMapper.insert(customerLinkman);
		if (count > 0) {
			return ServerResponse.createSUCCESS("添加成功");
		}
		return ServerResponse.createERROR("添加失败");
	}

	@Override
	public ServerResponse update(CustomerLinkman customerLinkman) {
	    int count = customerLinkmanMapper.updateByPrimaryKey(customerLinkman);
	    if (count > 0) {
			return ServerResponse.createSUCCESS("更新成功");
		}else{
			return ServerResponse.createERROR("更新失败");
		}
	}

	@Override
	public ServerResponse delete(Integer id) {
		int count = customerLinkmanMapper.deleteByPrimaryKey(id);
		if (count > 0) {
			return ServerResponse.createSUCCESS("删除成功");
		}
		return ServerResponse.createERROR("删除失败");
	}

}
