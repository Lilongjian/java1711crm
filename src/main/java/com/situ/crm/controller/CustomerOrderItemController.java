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
import com.situ.crm.entity.OrderItem;
import com.situ.crm.service.ICustomerOrderItemService;
import com.situ.crm.service.ICustomerOrderService;

@Controller
@RequestMapping("/customerOrderItem")
public class CustomerOrderItemController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
	@Autowired
	private ICustomerOrderItemService customerOrderItemService;
	
	@RequestMapping("selectById")
	@ResponseBody
	public List<OrderItem> selectById(Integer id){
		return customerOrderItemService.selectById(id);
	}
	
	
}
