package com.lin.lostandfound.service;

import java.util.Map;

import com.lin.lostandfound.domain.Notice;

public interface INoticeService {
	
	// 保存
	public boolean add(Notice notice);

	// 修改状态
	public boolean modifyStatus(Integer id, int status);

	// 删除
	public boolean remove(Integer id);
	
	// 查询最新一条
	public Notice queryNewNotice();
	
	// 查询所有统计
	public long queryAllCount(String key);

	// 查询所有
	public Map<String, Object> queryAll(String key, Integer pageIndex, Integer pageSize, String sortField, String sortOrder);

	// 根据id查询所有
	public Notice queryById(int id);

}
