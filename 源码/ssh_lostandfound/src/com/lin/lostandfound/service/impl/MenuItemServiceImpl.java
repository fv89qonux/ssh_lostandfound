package com.lin.lostandfound.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lin.lostandfound.dao.IMenuItenDao;
import com.lin.lostandfound.domain.MenuItem;
import com.lin.lostandfound.service.IMenuItemService;

@Service("menuItemService")
public class MenuItemServiceImpl implements IMenuItemService {

	@Autowired
	@Qualifier("menuItemDao")
	private IMenuItenDao menuItemDao;

	@Override
	public boolean add(MenuItem menuItem) {
		
		return menuItemDao.save(menuItem);
	}

	@Override
	public boolean modifyStatus(Integer id, int status) {

		return menuItemDao.updateStatus(id, status);
	}
	
	// 修改权限
	@Override
	public boolean modifyAuthority(Integer id, int authority) {
		
		return menuItemDao.updateAuthority(id, authority);
	}

	@Override
	public boolean remove(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	// 根据主键id查询
	@Override
	public MenuItem queryById(Integer id) {
		
		return menuItemDao.findById(id);
	}
	
	// 根据菜单id查询
	@Override
	public MenuItem queryByMenuId(String menuId) {
		
		return menuItemDao.findByMenuId(menuId);
	}
	
	// 根据父菜单id查询
	@Override
	public List<MenuItem> queryAllByParentId(String parentId) {
		
		return menuItemDao.findAllByParentId(parentId);
	}
	
	@Override
	public List<MenuItem> queryAll() {
		
		return menuItemDao.findAll();
	}
	
	@Override
	public List<MenuItem> queryAll(int authority) {
		
		return menuItemDao.findAll(authority);
	}

}
