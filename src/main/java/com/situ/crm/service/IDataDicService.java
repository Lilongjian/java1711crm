package com.situ.crm.service;

import java.util.List;
import java.util.Map;

import com.situ.crm.common.DataGrideResult;
import com.situ.crm.common.ServerResponse;
import com.situ.crm.entity.DataDic;

public interface IDataDicService {

	/*DataGrideResult<DataDic> pageList();*/

	DataGrideResult pageList(Integer page, Integer rows, DataDic dataDic);

	ServerResponse delete(String ids);

	ServerResponse add(DataDic dataDic);

	ServerResponse update(DataDic dataDic);

	List<DataDic> selectDataDicName();

	List<Map<String, String>> selectDataDicName1();

	List<Map<String, String>> selectLevel();

	List<Map<String, String>> selectRegion();

}
