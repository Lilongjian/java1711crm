package com.situ.crm.service;

import java.util.List;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.entity.Customer;

public interface ICustomerService {

	DataGrideResult<Customer> pageList();

}
