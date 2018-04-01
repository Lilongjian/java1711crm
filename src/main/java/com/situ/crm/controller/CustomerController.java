package com.situ.crm.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Data;
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
		Long curr = System.currentTimeMillis();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(curr);
		customer.setNum("KH"+(format.format(date)));
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
	@RequestMapping("/selectById")
	@ResponseBody
	public Customer selectById(Integer id){
		Customer customer = customerService.selectById(id);
		System.out.println(customer);
		return customer;
	}
	@RequestMapping("/lxrIndex")
	public String lcrIndex(){
		return "customerLinkMan_index";
	}
	@RequestMapping("/jwjlIndex")
	public String jwjlIndex(){
		return "customerContact_index";
	}
	public static void main(String[] args) {
		Long curr = System.currentTimeMillis();
	    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date(curr);
	     System.out.println("KH"+format.format(date));

	}
}
