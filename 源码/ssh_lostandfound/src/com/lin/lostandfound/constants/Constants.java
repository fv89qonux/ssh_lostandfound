package com.lin.lostandfound.constants;



public class Constants{
	
	// 数据源类型 （枚举）
	public enum DataSourceType{
		
		localDataSource,
		
		romoteDataSource
	}
	
	// 存入application域的path常量
	public static final String PATH = "path";
	
	//上传的根路经常量
	public static final String BASE_UPLOAD_PATH = "/WEB-INF/static/upload";

	// 页面大小常量
	public static final int PAGE_SIZE_10 = 10;
	public static final int PAGE_SIZE_15 = 15;
	public static final int PAGE_SIZE_20 = 20;
	public static final int PAGE_SIZE_25 = 25;
	public static final int PAGE_SIZE_30 = 30;

	// 登录用户保存在Session中的域对象常量
	public static final String CODE = "code"; //验证码
	public static final String USER = "user";
	public static final String ADMIN = "admin";

	// 用户角色状态常量
	public static final int USER_STATE_LOCK = 0; // 冻结用户 
	public static final int USER_STATE_NORMAL = 1; // 普通用户
	public static final int USER_STATE_ADMIN = 2; // 管理员
	public static final int USER＿STATE_SUPERADMIN = 3; // 超级管理员（系统管理员）
	
	// 物品状态常量
	public static final int THINGS_STATE_PUBLISHED = 0; // 发布状态
	public static final int THINGS_STATE_SUCCESS = 1; // 成功状态
	public static final int THINGS_STATE_DELETE = 2; // 删除状态

}
