package com.lin.lostandfound.dao;

import java.util.List;

import com.lin.lostandfound.domain.MenuItem;

public interface IMenuItenDao {

	// 保存
	public boolean save(MenuItem menuItem);

	// 修改状态
	public boolean updateStatus(Integer id, int status);
	
	// 修改权限
	public boolean updateAuthority(Integer id, int authority);

	// 删除
	public boolean delete(Integer id);
	
	// 根据主键id查询
	public MenuItem findById(Integer id);
	
	// 根据菜单id查询
	public MenuItem findByMenuId(String menuId);
	
	// 根据父菜单id查询
	public List<MenuItem> findAllByParentId(String parentId);

	// 查询所有
	public List<MenuItem> findAll();

	// 根据权限查询所有（status）
	public List<MenuItem> findAll(int authority);

}
