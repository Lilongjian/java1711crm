package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.CustomerLinkman;

public interface ICustomerLinkManService {

	List<CustomerLinkman> selectById(Integer id);

	ServerResponse add(CustomerLinkman customerLinkman);

	ServerResponse update(CustomerLinkman customerLinkman);

	ServerResponse delete(Integer id);
	

}
