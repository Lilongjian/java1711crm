package com.situ.crm.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.Customer;
import com.situ.crm.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/index")
	public String index() {
		return "customer_index";
	}
	@RequestMapping("/pageList")
	@ResponseBody
	public DataGrideResult pageList(Integer page, Integer rows, Customer customer) {
		 		return customerService.pageList(page, rows, customer);
		  	}
	@RequestMapping("/delete")
	 	@ResponseBody
	 	public ServerResponse delete(String ids) {
	 		return customerService.delete(ids);
	 	}
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(Customer customer){
		return customerService.add(customer);
	}
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(Customer customer){
		return customerService.update(customer);
	}
	@RequestMapping("/selectManagerName")
	@ResponseBody
	public List<Map<String, String>> selectManagerName(){
		return customerService.selectManagerName();
	}
}
