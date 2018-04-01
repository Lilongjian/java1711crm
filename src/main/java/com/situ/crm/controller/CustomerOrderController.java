package com.situ.crm.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.CustomerOrder;
import com.situ.crm.service.ICustomerOrderService;

@Controller
@RequestMapping("/customerOrder")
public class CustomerOrderController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	@Autowired
	private ICustomerOrderService customerOrderService;
	
	@RequestMapping("/selectById")
	@ResponseBody
	public List<CustomerOrder> selectById(Integer id){
		return customerOrderService.selectById(id);
	}
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(Integer id) {
		return customerOrderService.delete(id);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(CustomerOrder customerOrder) {
		return customerOrderService.add(customerOrder);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CustomerOrder customerOrder) {
		return customerOrderService.update(customerOrder);
	}
}
