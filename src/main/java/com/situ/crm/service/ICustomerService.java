package com.situ.crm.service;

import java.util.List;
import java.util.Map;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.Customer;

public interface ICustomerService {

	DataGrideResult pageList(Integer page, Integer rows, Customer customer);

	ServerResponse delete(String ids);

	ServerResponse add(Customer customer);

	ServerResponse update(Customer customer);

	List<Map<String, String>> selectManagerName();

}
