package com.kwd.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSONObject;

/**
 * 
 * <http请求> <功能详细描述>
 * 
 * @author wendong.kang
 * @version [OEMS V100R002C01, 2014-3-25]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HttpPostUtils {
	/**
	 * 
	 * <get方式HTTP请求> <功能详细描述>
	 * 
	 * @param urlStr
	 *            请求地址
	 * @param param
	 *            请求参数
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static JSONObject sendHttpGet(String urlStr, String param) {
		JSONObject obj = null;
		try {
			String urlName = urlStr + "?" + param;
			URL url = new URL(urlName);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			conn.setUseCaches(false);// 不使用缓存
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.connect();

			// 读取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			//System.out.println(sb);
			String jsonStr = sb.toString();
			obj = JSONObject.fromObject(jsonStr);
			
			String session_value =conn.getHeaderField("Set-Cookie");
			String[] sessionId = session_value.split(";");
			for (String str : sessionId) {
				if(str != null){
					String[] temp=str.split("=");
					System.out.println(temp[0]+"###"+temp[1]);
				}
			}
			
			
			reader.close();
			// 断开连接
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 
	 * <post方式HTTP请求> <功能详细描述>
	 * 
	 * @param urlStr
	 *            请求地址
	 * @param param
	 *            参数
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static JSONObject sendHttpPost(String urlStr, String param) {
		JSONObject obj = null;
		try {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);// 不使用缓存
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.connect();

			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			out.writeBytes(param);
			out.flush();
			out.close();

			// 读取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			// System.out.println(sb);
			// String jsonStr = sb.substring(1, sb.lastIndexOf(")"));
			obj = JSONObject.fromObject(sb.toString());
			reader.close();
			// 断开连接
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;

	}

	public String test() {
		String account = "admin";
		String password = "888888";
		String paramStr = "vo.loginname=" + account + "&vo.loginpwd="
				+ password + "&vo.relogin=1";
		//System.out.println(paramStr);
		String urlStr = "http://192.168.0.26:8089/moco/login/login_initAction.do";
		String result = null;
		try {
			JSONObject resultObj = HttpPostUtils.sendHttpGet(urlStr, paramStr);
			result = resultObj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + "###" + e.getStackTrace());
		}
		return result;
	}

	public String testBaidu() {

		String urlStr = "http://www.baidu.com";
		String result = null;

		try {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);// 不使用缓存
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.connect();

			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			out.writeBytes("");
			out.flush();
			out.close();

			// 读取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes("GBK"), "GBK");
				sb.append(lines);
			}

			try {
				// JSONObject obj = JSONObject.fromObject(sb.toString());
				result = sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
				reader.close();
				// 断开连接
				conn.disconnect();
			}
			reader.close();
			// 断开连接
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String testBaidu2() {
		String result = null;
		URL url = null;
		HttpURLConnection connection = null;
		InputStreamReader in = null;
		try {
			url = new URL("http://www.baidu.com");
			connection = (HttpURLConnection) url.openConnection();
			in = new InputStreamReader(connection.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(in);
			StringBuffer strBuffer = new StringBuffer();
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				strBuffer.append(line);
			}
			result = strBuffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return result;

	}

	public static void main(String[] args) {
		HttpPostUtils h = new HttpPostUtils();
		String result = h.testBaidu();
		System.out.println(result);
	}
}
