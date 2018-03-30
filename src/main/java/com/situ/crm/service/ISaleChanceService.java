package com.situ.crm.service;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.SaleChance;
import com.situ.crm.entity.SaleChanceVo;

public interface ISaleChanceService {
	DataGrideResult pageList(Integer page, Integer rows, SaleChanceVo saleChanceVo);

	ServerResponse delete(String ids);

	ServerResponse add(SaleChance saleChance);

	ServerResponse update(SaleChance saleChance);

	ServerResponse<SaleChance> selectById(Integer id);

	ServerResponse updateDevResult(Integer saleChanceId, Integer devResult);
}
