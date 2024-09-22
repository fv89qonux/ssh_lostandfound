package com.lin.lostandfound.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class DataBaseBackupUtils {

	public static void main(String[] args) throws IOException{
		System.out.println("mysqlPath：" +getMysqlPath());
		
		String dataBaseServerPath = getMysqlPath()+"bin";
		backup(dataBaseServerPath, "c:\\lostandfound.sql");
		//recover("c:\\lostandfound.sql");
	}
	public static void backup(String dataBaseServerPath, String savePath) throws IOException{
		System.out.println(dataBaseServerPath +"\\mysqldump -h112.74.191.147 -u root -proot -P3306 --ignore-table=lostandfound.t_backup_database lostandfound");
		Runtime runtime = Runtime.getRuntime();
		//-u后面是用户名，-p是密码-p后面最好不要有空格，-family是数据库的名字
		Process process = runtime.exec(dataBaseServerPath +"\\mysqldump -h112.74.191.147 -u root -proot -P3306 --ignore-table=lostandfound.t_backup_database lostandfound");
		InputStream inputStream = process.getInputStream();//得到输入流，写成.sql文件
		InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
		BufferedReader br = new BufferedReader(reader);
		String inStr = null;
		StringBuffer sb = new StringBuffer();
		String outStr;
		while((inStr  = br.readLine()) != null){
			sb.append(inStr +"\r\n");
		}
		outStr = sb.toString();
		//System.out.println(outStr);
		FileOutputStream fout = new FileOutputStream(savePath);
		OutputStreamWriter writer = new OutputStreamWriter(fout, "UTF-8");
		writer.write(outStr);
        writer.flush();
		fout.close();
		br.close();
		writer.close();
		reader.close();
		inputStream.close();
		System.out.println(getErrMsg(process));
	}
	public static void recover(String dataBaseServerPath, String savePath) throws IOException{
		Runtime runtime = Runtime.getRuntime();
		//-u后面是用户名，-p是密码-p后面最好不要有空格，-family是数据库的名字，--default-character-set=utf8，这句话一定的加
		//我就是因为这句话没加导致程序运行成功，但是数据库里面的内容还是以前的内容，最好写上完成的sql放到cmd中一运行才知道报错了
		//错误信息：
		//mysql: Character set 'utf-8' is not a compiled character set and is not specified in the '
		//C:\Program Files\MySQL\MySQL Server 5.5\share\charsets\Index.xml' file ERROR 2019 (HY000): Can't
		// initialize character set utf-8 (path: C:\Program Files\MySQL\MySQL Server 5.6\share\charsets\)，
		//又是讨人厌的编码问题，在恢复的时候设置一下默认的编码就可以了。
		Process process = runtime.exec(dataBaseServerPath +"\\mysql -u root -proot --default-character-set=utf8 lostandfound");
		OutputStream outputStream = process.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(savePath)));
		String str = null;
		StringBuffer sb = new StringBuffer();
		while((str = br.readLine()) != null){
			sb.append(str+"\r\n");
		}
		str = sb.toString();
		System.out.println(str);
		OutputStreamWriter writer = new OutputStreamWriter(outputStream,"UTF-8");
		writer.write(str);
		writer.flush();
		outputStream.close();
		br.close();
		writer.close();
	}
	
	private static String getErrMsg(Process p) throws IOException{  
        StringBuilder errMsg = new StringBuilder();  
        InputStream in = p.getErrorStream();  
        BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));  
        for(String inStr = null;(inStr = br.readLine()) != null;){  
            errMsg.append(inStr).append("<br>");  
        }  
        in.close();  
        br.close();  
        return errMsg.length() == 0 ? null : errMsg.toString();  
    }  

	/**
	* 获取mysql安装路径
	* @return
	*/
	public static String getMysqlPath(){
		Map<String,String> map = new HashMap<String,String>();
		try {
			Process ps = null;
			//当路径中有空格时，要把路径打上引号。
			//ps = Runtime.getRuntime().exec("reg query \"HKEY_LOCAL_MACHINE\\SOFTWARE\\MySQL AB\"");
			ps = Runtime.getRuntime().exec("reg query \"HKEY_LOCAL_MACHINE\\SOFTWARE\\Wow6432Node\\MySQL AB\"");
			//ps.getOutputStream().close();
			InputStreamReader ir = new InputStreamReader(ps.getInputStream());
			String line;
			String regPath = null;
			BufferedReader br = new BufferedReader(ir);
			
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				regPath = line;
			}

			ps = Runtime.getRuntime().exec("reg query "+"\""+regPath+"\"");
			ps.getOutputStream().close();
			ir = new InputStreamReader(ps.getInputStream());
			
			br = new BufferedReader(ir);
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				String[] keyValue = line.split("REG_SZ");
				//System.out.println(keyValue.length);
				if(keyValue.length >=2 ){
					map.put(keyValue[0].trim(),keyValue[1].trim());
				}
				regPath = line;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		String mysqlPath = "";
		if(map.size() > 0)
			mysqlPath = map.get("Location");
		
		return mysqlPath;
	}
}