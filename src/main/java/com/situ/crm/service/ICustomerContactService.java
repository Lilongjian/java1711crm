package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.CustomerContact;

public interface ICustomerContactService {

	List<CustomerContact> selectById(Integer id);

	ServerResponse add(CustomerContact customerContact);

	ServerResponse delete(Integer id);

	ServerResponse update(CustomerContact customerContact);

}
