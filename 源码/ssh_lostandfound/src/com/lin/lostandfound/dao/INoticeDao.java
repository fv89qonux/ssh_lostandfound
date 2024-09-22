package com.lin.lostandfound.dao;

import java.util.List;

import com.lin.lostandfound.domain.Notice;

public interface INoticeDao {
	
	// 保存
	public boolean save(Notice notice);

	// 修改状态
	public boolean updateStatus(Integer id, int status);

	// 删除
	public boolean delete(Integer id);
	
	// 查询最新一条
	public Notice findNewNotice();
	
	// 查询所有统计
	public long findAllCount(String key);

	// 查询所有
	public List<Notice> findAll(String key, Integer pageIndex,
			Integer pageSize, String sortField, String sortOrder);

	// 根据id查询所有
	public Notice findById(int id);

}
