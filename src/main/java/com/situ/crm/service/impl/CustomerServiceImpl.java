package com.situ.crm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.DataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.Customer;
import com.situ.crm.mapper.CustomerMapper;
import com.situ.crm.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public DataGrideResult pageList(Integer page, Integer rows, Customer customer) {
		//1.设置分页
 		PageHelper.startPage(page, rows);
 		//2.执行查询(查询的是分页之后的数据)
 		List<Customer> list = customerMapper.pageList(customer);
 		//3.得到满足条件的所有数据的数量，而上面的list是满足这个条件的某一页的数据
 		PageInfo pageInfo = new PageInfo<>(list);
 		Integer total = (int) pageInfo.getTotal();
 		return new DataGrideResult<>(total, list);
	}

	@Override
	public ServerResponse delete(String ids) {
        String[] idsArray = ids.split(",");
        for (String id : idsArray) {
			customerMapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
		return ServerResponse.createSUCCESS("删除成功");
	}

	@Override
	public ServerResponse add(Customer customer) {
		int count = customerMapper.insert(customer);
		if (count > 0) {
			return ServerResponse.createSUCCESS("添加成功");
		}
		return ServerResponse.createERROR("添加失败");
	}

	@Override
	public ServerResponse update(Customer customer) {
		int count = customerMapper.updateByPrimaryKey(customer);
		if (count > 0) {
			return ServerResponse.createSUCCESS("更新成功");
		}
		return ServerResponse.createERROR("添加失败");
	}

	@Override
	public List<Map<String, String>> selectManagerName() {
		List<String> managerName = customerMapper.selectManagerName();
		List<Map<String, String>> list = new ArrayList<>();
		for (String name : managerName) {
			Map<String, String> map = new HashMap<>();
			map.put("managerName", name);
			list.add(map);
		}
		return list;
	}

}
