package com.situ.crm.service.impl;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.entity.Customer;
import com.situ.crm.entity.User;
import com.situ.crm.mapper.UserMapper;
import com.situ.crm.service.IUserService;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper UserMapper;

	@Override
	public DataGrideResult<User> pageList() {
		List<User> list = UserMapper.pageList();
		System.out.println(list);
		return new DataGrideResult<User>(list.size(), list);
	}

}
