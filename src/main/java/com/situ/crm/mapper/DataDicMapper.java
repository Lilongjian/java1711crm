package com.situ.crm.mapper;

import java.util.List;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.entity.DataDic;
import com.situ.crm.entity.User;

public interface DataDicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataDic record);

    int insertSelective(DataDic record);

    DataDic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataDic record);

    int updateByPrimaryKey(DataDic record);

	List<DataDic> pageList(DataDic dataDic);

	DataGrideResult getDataDicName();
}