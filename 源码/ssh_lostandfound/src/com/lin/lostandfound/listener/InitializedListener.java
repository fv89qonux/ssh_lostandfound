package com.lin.lostandfound.listener;

import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.lin.lostandfound.constants.Constants;
import com.lin.lostandfound.utils.TimerManager;

public class InitializedListener implements ServletContextListener {
	
	private TimerManager timerManager;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		System.out.println("初始化path：" +servletContext.getContextPath());
		
		String webSiteTitle = servletContext.getInitParameter("webSiteTitle");
		String copyRight = servletContext.getInitParameter("copyRight");
		
		servletContext.setAttribute("webSiteTitle", webSiteTitle);
		servletContext.setAttribute("copyRight", copyRight);
		servletContext.setAttribute(Constants.PATH, servletContext.getContextPath());
		
		// 当前年份
		servletContext.setAttribute("thisYear", Calendar.getInstance().get(Calendar.YEAR));
		
		// 初始化数据库备份
		initDataBaseBackup(servletContext);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		String path = (String) servletContextEvent.getServletContext().getAttribute(Constants.PATH);
		servletContextEvent.getServletContext().removeAttribute(Constants.PATH);
		System.out.println("销毁path：" +path);
		
		// 销毁数据库备份
		destroyedDataBaseBackup();
	}
	
	private void initDataBaseBackup(ServletContext servletContext) {
		System.out.println("数据库备份初始化...");
		String backuptime = servletContext.getInitParameter("backuptime");
		String timeInterval = servletContext.getInitParameter("period");
		String[] time = timeInterval.split("\\*");
		long period = 1;
		for(String value : time)
			period *= Long.parseLong(value);
		
		timerManager = new TimerManager();
		timerManager.start(backuptime, period);
	}
	
	private void destroyedDataBaseBackup() {
		if (timerManager != null)
			timerManager.stop();
	}
}
