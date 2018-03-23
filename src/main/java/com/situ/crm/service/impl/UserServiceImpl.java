package com.situ.crm.service.impl;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.DataGrideResult;
import com.situ.crm.entity.Customer;
import com.situ.crm.entity.User;
import com.situ.crm.mapper.UserMapper;
import com.situ.crm.service.IUserService;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public DataGrideResult pageList(Integer page, Integer rows, User user) {
		//1.设置分页
 		PageHelper.startPage(page, rows);
 		//2.执行查询(查询的是分页之后的数据)
 		List<User> list = userMapper.pageList(user);
 		//3.得到满足条件的所有数据的数量，而上面的list是满足这个条件的某一页的数据
 		PageInfo pageInfo = new PageInfo<>(list);
 		Integer total = (int) pageInfo.getTotal();
 		return new DataGrideResult<>(total, list);
	}

	/*@Override
	public DataGrideResult<User> pageList() {
		List<User> list = UserMapper.pageList();
		System.out.println(list);
		return new DataGrideResult<User>(list.size(), list);
	}*/

}
