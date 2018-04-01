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
import com.situ.crm.entity.CustomerContact;
import com.situ.crm.entity.CustomerLinkman;
import com.situ.crm.service.ICustomerContactService;
import com.situ.crm.service.ICustomerLinkManService;

@Controller
@RequestMapping("/customerContact")
public class CustomerContactController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	@Autowired
	private ICustomerContactService customerContactService;
	
	@RequestMapping("/selectById")
	@ResponseBody
	public List<CustomerContact> selectById(Integer id){
		return customerContactService.selectById(id);
	}
	@RequestMapping("/delete")
	@ResponseBody
	public ServerResponse delete(Integer id) {
		return customerContactService.delete(id);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(CustomerContact customerContact) {
		return customerContactService.add(customerContact);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(CustomerContact customerContact) {
		return customerContactService.update(customerContact);
	}
}
