package com.situ.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.crm.entity.SaleChance;
import com.situ.crm.entity.SaleChanceVo;

public interface SaleChanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SaleChance record);

    int insertSelective(SaleChance record);

    SaleChance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SaleChance record);

    int updateByPrimaryKey(SaleChance record);

	List<SaleChance> pageList(SaleChanceVo saleChanceVo);

	int updateDevResult(@Param(value="id")Integer id, @Param(value="devResult")Integer devResult);
}