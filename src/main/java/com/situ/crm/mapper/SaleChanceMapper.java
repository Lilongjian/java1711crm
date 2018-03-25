package com.situ.crm.mapper;

import java.util.List;

import com.situ.crm.entity.SaleChance;

public interface SaleChanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SaleChance record);

    int insertSelective(SaleChance record);

    SaleChance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SaleChance record);

    int updateByPrimaryKey(SaleChance record);

	List<SaleChance> pageList(SaleChance saleChance);
}