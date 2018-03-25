package com.situ.crm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.SaleChance;
import com.situ.crm.service.ISaleChanceService;

@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {
	@Autowired  
	private ISaleChanceService saleChanceService;

	@RequestMapping("/index")
	public String index() {
		return "saleChance_index";
	}
	/*public DataGrideResult<SaleChance> pageList() {
		return saleChanceService.pageList();
	}*/
	@RequestMapping("/pageList")
	@ResponseBody
	public DataGrideResult pageList(Integer page, Integer rows, SaleChance saleChance) {
		 		return saleChanceService.pageList(page, rows, saleChance);
		  	}
	@RequestMapping("/delete")
	 	@ResponseBody
	 	public ServerResponse delete(String ids) {
	 		return saleChanceService.delete(ids);
	 	}
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(SaleChance saleChance){
		return saleChanceService.add(saleChance);
	}
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(SaleChance saleChance){
		return saleChanceService.update(saleChance);
	}
}
