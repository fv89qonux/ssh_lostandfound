package com.lin.lostandfound.dao;

import java.util.List;

import com.lin.lostandfound.domain.SystemLog;

public interface ISystemLogDao {
	
	// 保存
	public boolean svae(SystemLog systemLog);
	
	// 批量删除
	public boolean delete(long[] logsId);
	
	// 统计所有（分页）
	public long findAllCount(String key);
	
	// 查询所有
	public List<SystemLog> findAll(String key, Integer pageIndex,
			Integer pageSize, String sortField, String sortOrder);

}
