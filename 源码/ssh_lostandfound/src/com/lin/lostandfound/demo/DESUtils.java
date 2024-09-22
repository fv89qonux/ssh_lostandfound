package com.lin.lostandfound.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

public class DESUtils {

	public DESUtils() {

	}

	public DESUtils(String str) {
		getKey(str);// ����ܳ�
	}

	/**
	 * ��ݲ������KEY
	 */
	public static Key getKey(String strKey) {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(strKey.getBytes()));
			Key key = generator.generateKey();
			generator = null;
			
			return key;
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlMap class. Cause: " + e);
		}
	}

	/**
	 * �ļ�file���м��ܲ�����Ŀ���ļ�destFile��
	 * 
	 * @param file
	 *            Ҫ���ܵ��ļ� ��c:/test/srcFile.txt
	 * @param destFile
	 *            ���ܺ��ŵ��ļ��� ��c:/���ܺ��ļ�.txt
	 */
	public static void encrypt(String file, String destFile, Key key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		InputStream is = new FileInputStream(file);
		OutputStream out = new FileOutputStream(destFile);
		CipherInputStream cis = new CipherInputStream(is, cipher);
		byte[] buffer = new byte[1024];
		int r;
		while ((r = cis.read(buffer)) > 0) {
			out.write(buffer, 0, r);
		}
		cis.close();
		is.close();
		out.close();
	}

	/**
	 * �ļ�����DES�㷨�����ļ�
	 * 
	 * @param file
	 *            �Ѽ��ܵ��ļ� ��c:/���ܺ��ļ�.txt * 
	 * @param destFile ���ܺ��ŵ��ļ��� ��c:/
	 *            test/���ܺ��ļ�.txt
	 */
	public static void decrypt(String file, String dest, Key key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		InputStream is = new FileInputStream(file);
		OutputStream out = new FileOutputStream(dest);
		CipherOutputStream cos = new CipherOutputStream(out, cipher);
		byte[] buffer = new byte[1024];
		int r;
		while ((r = is.read(buffer)) >= 0) {
			System.out.println();
			cos.write(buffer, 0, r);
		}
		cos.close();
		out.close();
		is.close();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(DESUtils.getKey("aaa").equals(DESUtils.getKey("aaa")));
		Key key = DESUtils.getKey(new Date().toString());
		DESUtils.encrypt("E:/luqu.docx", "E:/����luqu.docx", key); // ����
		DESUtils.decrypt("E:/����luqu.docx", "E:/luquNew.docx", key); // ����

	}

}
