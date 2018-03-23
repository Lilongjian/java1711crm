package com.situ.crm.service;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.Customer;
import com.situ.crm.entity.User;

public interface IUserService {

	/*DataGrideResult<User> pageList();*/

	DataGrideResult pageList(Integer page, Integer rows, User user);

	ServerResponse delete(String ids);

}
