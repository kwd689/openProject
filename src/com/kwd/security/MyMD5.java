package com.kwd.security;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;


/*****
 * 
 * md5/Sha/base64加密
 * 
 * @author wendong.kang
 * @version [MOCO V1.0, 2014-6-4]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 * xmlsec-1.5.3.jar
 */
public final class MyMD5 {
	/***
	 * 
	 * <md5加密>方法1
	 * 
	 * @param str
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String getMD5(String str) {
		String reStr = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");// 创建具有指定算法名称的信息摘要
			md.update(str.getBytes());// 使用指定的字节更新摘要。
			byte ss[] = md.digest();// 通过执行诸如填充之类的最终操作完成哈希计算
			reStr = bytes2String(ss);
		} catch (NoSuchAlgorithmException e) {

		}
		return reStr;
	}

	/***
	 * 
	 * <md5加密>方法2
	 * 
	 * @param str
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String getMD5Two(String str) {
		String reStr = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");// 创建具有指定算法名称的信息摘要
			md.update(str.getBytes());// 使用指定的字节更新摘要。
			byte ss[] = md.digest();// 通过执行诸如填充之类的最终操作完成哈希计算
			reStr = bytesToString(ss);
		} catch (NoSuchAlgorithmException e) {

		}
		return reStr;
	}

	/***
	 * 
	 * <SHA加密>
	 * 
	 * @param str
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String getSHA(String str) {
		String reStr = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(str.getBytes());
			byte ss[] = md.digest();
			reStr = bytesToString(ss);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return reStr;
	}

	/****
	 * 
	 * byte[] 数组转换成字符串（方法1）
	 * 
	 * @param aa
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private static String bytes2String(byte[] aa) {// 将字节数组转换为字符串
		String hash = "";
		for (int i = 0; i < aa.length; i++) {// 循环数组
			int temp;
			if (aa[i] < 0) // 如果小于零，将其变为正数
				temp = 256 + aa[i];
			else
				temp = aa[i];
			if (temp < 16)
				hash += "0";
			hash += Integer.toString(temp, 16);// 转换为16进制
		}
		hash = hash.toUpperCase();// 全部转换为大写
		return hash;
	}

	/****
	 * 
	 * byte[] 数组转换成字符串（方法2）
	 * 
	 * @param aa
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private static String bytesToString(byte[] aa) {
		StringBuilder hash = new StringBuilder("");
		for (int i = 0; i < aa.length; i++) {
			String tempStr = Integer.toHexString(0xff & aa[i]);
			if (tempStr.length() == 1) {
				tempStr = "0" + tempStr;
			}
			hash.append(tempStr.toUpperCase());
		}
		return hash.toString();
	}

	/****
	 * 
	 * sun base64 encode(不推荐)
	 * 
	 * @param s
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public String encodeBase64Sun(String s) {
		return new sun.misc.BASE64Encoder().encode(s.getBytes());
	}

	/*****
	 * 
	 * sun base64 decode(不推荐)
	 * 
	 * @param s
	 * @return
	 * @throws IOException
	 * @see [类、类#方法、类#成员]
	 */
	public String decodeBase64Sun(String s) {
		String decode = null;
		try {
			byte[] str = new sun.misc.BASE64Decoder().decodeBuffer(s);
			decode = new String(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return decode;
	}
    /*****
     * 
     * apache Base64 encode
     * @param s
     * @return
     * @see [类、类#方法、类#成员]
     */
	public String encodeBase64Apache(String s) {
		String strEncode = null;
		byte[] encodeByte = s.getBytes();
		strEncode = Base64.encode(encodeByte);
		return strEncode;
	}
    public String decodeBase64Apache(String s){
    	String strDecode = null;
    	byte[] decodeByte = null;
    	try {
    		decodeByte = Base64.decode(s);
    		strDecode = new String(decodeByte);
		} catch (Base64DecodingException e) {
			e.printStackTrace();
		}
		return strDecode;
    }
	public static void main(String[] args) {
		MyMD5 md5 = new MyMD5();
		String str1 = md5.getMD5("miartech");
		System.out.println("md5加密：" + str1);
		String str2 = md5.getMD5Two("miartech");
		System.out.println("md5加密：" + str2);
		String str3 = md5.getSHA("miartech");
		System.out.println("sha加密：" + str3);
		String s = "www.miartech.com";
		System.out.println("加密前：" + s);
		String encodeSunStr = md5.encodeBase64Sun(s);
		System.out.println("sun BASE64 Encode : " + encodeSunStr);
		String decodeSunStr = md5.decodeBase64Sun(encodeSunStr);
		System.out.println("sun BASE64 Decode : " + decodeSunStr);
		
		String encodeApacheStr = md5.encodeBase64Sun(s);
		System.out.println("apache BASE64 Encode : " + encodeApacheStr);
		String decodeApacheStr = md5.decodeBase64Sun(encodeApacheStr);
		System.out.println("apache BASE64 Decode : " + decodeApacheStr);
	}
}
