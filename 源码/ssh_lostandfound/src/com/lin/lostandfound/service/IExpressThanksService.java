package com.lin.lostandfound.service;

import java.util.Map;

import com.lin.lostandfound.domain.ExpressThanks;


public interface IExpressThanksService {

	// 添加
	public boolean add(ExpressThanks expressThanks);

	// 批量修改状态
	public boolean modifyStatus(String thanksId, int status);

	// 修改状态
	public boolean modifyStatus(long thanksId, int status);

	// 删除
	public boolean remove(String thanksId);

	// 查询所有统计数量
	public long queryAllCount(String key);

	// 查询所有
	public Map<String, Object> queryAll(String key, Integer pageIndex,
			Integer pageSize, String sortField, String sortOrder);

	// 根据id查询
	public ExpressThanks queryById(long id);

}
