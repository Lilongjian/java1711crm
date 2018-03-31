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
import com.situ.crm.entity.CusDevPlan;
import com.situ.crm.entity.CustomerLinkman;
import com.situ.crm.service.ICustomerLinkManService;

@Controller
@RequestMapping("/customerLinkMan")
public class CustomerLinkManController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	@Autowired
	private ICustomerLinkManService customerLinkManService;

	@RequestMapping("/selectById")
	@ResponseBody
	public List<CustomerLinkman> selectById(Integer id) {
		return customerLinkManService.selectById(id);
	}
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(Integer id) {
		return customerLinkManService.delete(id);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(CustomerLinkman customerLinkman) {
		return customerLinkManService.add(customerLinkman);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CustomerLinkman customerLinkman) {
		return customerLinkManService.update(customerLinkman);
	}
}
