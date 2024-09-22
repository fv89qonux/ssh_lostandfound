package com.lin.lostandfound.aspect;


import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import com.lin.lostandfound.annotation.DataSource;
import com.lin.lostandfound.datasource.DataSourceContextHolder;

public class DataSourceAspect implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {

		DataSourceContextHolder.clearDataSourceType();
	}

	@Override
	public void before(Method method, Object[] args, Object target)	throws Throwable {
		
		if (method.isAnnotationPresent(DataSource.class)) {
			DataSource datasource = method.getAnnotation(DataSource.class);
			DataSourceContextHolder.setDataSourceType(datasource.name());
			System.out.println("2\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\\n");
		}

	}
}
