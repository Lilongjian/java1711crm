package com.situ.crm.service.impl;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.crm.common.DataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.Customer;
import com.situ.crm.entity.SaleChance;
import com.situ.crm.entity.SaleChanceVo;
import com.situ.crm.mapper.SaleChanceMapper;
import com.situ.crm.service.ISaleChanceService;
@Service
public class SaleChanceServiceImpl implements ISaleChanceService{
	@Autowired
	private SaleChanceMapper saleChanceMapper;

	@Override
	public DataGrideResult pageList(Integer page, Integer rows, SaleChanceVo saleChanceVo) {
		//1.设置分页
 		PageHelper.startPage(page, rows);
 		//2.执行查询(查询的是分页之后的数据)
 		List<SaleChance> list = saleChanceMapper.pageList(saleChanceVo);
 		//3.得到满足条件的所有数据的数量，而上面的list是满足这个条件的某一页的数据
 		PageInfo pageInfo = new PageInfo<>(list);
 		Integer total = (int) pageInfo.getTotal();
 		return new DataGrideResult<>(total, list);
	}

	@Override
	public ServerResponse delete(String ids) {
        String[] idsArray = ids.split(",");
        for (String id : idsArray) {
			saleChanceMapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
		return ServerResponse.createSUCCESS("删除成功");
	}

	@Override
	public ServerResponse add(SaleChance saleChance) {
		int count = saleChanceMapper.insert(saleChance);
		if (count > 0) {
			return ServerResponse.createSUCCESS("添加成功");
		}
		return ServerResponse.createERROR("添加失败");
	}

	@Override
	public ServerResponse update(SaleChance saleChance) {
		int count = saleChanceMapper.updateByPrimaryKey(saleChance);
		if (count > 0) {
			return ServerResponse.createSUCCESS("更新成功");
		}
		return ServerResponse.createERROR("添加失败");
	}

	@Override
	 	public ServerResponse<SaleChance> selectById(Integer saleChanceId) {
	 		SaleChance saleChance = saleChanceMapper.selectByPrimaryKey(saleChanceId);
	 		if (saleChance != null) {
	 			return ServerResponse.createSUCCESS("查找成功", saleChance);
	 		}
	 		return ServerResponse.createERROR("查找失败");
	 	}

	@Override
 	public ServerResponse updateDevResult(Integer id, Integer devResult) {
 		int count = saleChanceMapper.updateDevResult(id, devResult);
 		if (count > 0) {
 			return ServerResponse.createSUCCESS("更新成功");
 		}
 		return ServerResponse.createERROR("更新失败");
 	}

	/*@Override
	public DataGrideResult<SaleChance> pageList() {
		List<SaleChance> list = SaleChanceMapper.pageList();
		System.out.println(list);
		return new DataGrideResult<SaleChance>(list.size(), list);
	}*/

}
