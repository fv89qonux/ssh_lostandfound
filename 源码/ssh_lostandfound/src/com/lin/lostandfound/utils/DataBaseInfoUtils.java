package com.lin.lostandfound.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DataBaseInfoUtils {
	
	private DataBaseInfoUtils(){
		
	}
	
	public static Map<String, String> getDataBaseInfo(){
		InputStream is = DataBaseInfoUtils.class.getClassLoader()
				.getResourceAsStream("/resource/database.properties");
		Properties ps = new Properties();
		Map<String, String> map = null;
		try {
			ps.load(is);
			String username = ps.getProperty("user");
			String password = ps.getProperty("password");
			String url = ps.getProperty("url");
			if(url != null)
				url = url.substring(url.indexOf("//") + 2);
			
			url = url.substring(0, url.indexOf("?"));
			//System.out.println(url);
			String[] strVlaue = url.trim().split("/");
			String ip = strVlaue[0].split(":")[0];
			String port = strVlaue[0].split(":")[1];
			String databaseName = strVlaue[1];
			map = new HashMap<String, String>();
			map.put("username", username);
			map.put("password", password);
			map.put("ip", ip);
			map.put("port", port);
			map.put("databaseName", databaseName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;
	}

}
