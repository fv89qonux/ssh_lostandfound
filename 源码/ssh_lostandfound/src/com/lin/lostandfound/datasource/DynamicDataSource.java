package com.lin.lostandfound.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
	
	@Override
	protected Object determineCurrentLookupKey() {
		
		return DataSourceContextHolder.getDataSourceType();
	}

}
