package com.situ.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.entity.Customer;
import com.situ.crm.mapper.CustomerMapper;
import com.situ.crm.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public DataGrideResult<Customer>  pageList() {
		int total = customerMapper.pageList().size();
		List<Customer> rows = customerMapper.pageList();
		return new DataGrideResult(total,rows);	}

}
