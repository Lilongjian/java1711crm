package com.situ.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.crm.entity.Customer;
import com.situ.crm.mapper.CustomerMapper;
@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<Customer> pageList() {
		return customerMapper.pageList();
	}

}
