/*
 * 文 件 名:  RegexTest01.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-6-13
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.regex;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  wendong.kang
 * @version  [MOCO V1.0, 2014-6-13]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class RegexTest01 {

	/**
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param args
	 * @see [类、类#方法、类#成员]
	 */
	public static void main(String[] args) {
		String str ="sid=201406130856324851&vo.userId=1&vo.termname=%E6%B5%8B%E8%AF%95%E8%AE%BE%E5%A4%87&vo.typeId=1&vo.termAddr=88393837&vo.status=1&vo.gwId=2&vo.isvalId=1&vo.regName=%E4%B8%AD%E5%8D%8E%E4%BA%BA%E6%B0%91%E5%85%B1%E5%92%8C%E5%9B%BD&vo.varId=1&vo.remark=%E4%B8%AD%E5%9B%BD%E5%85%B1%E4%BA%A7%E5%85%9A&vo.apId=3";
		String[] arrStr = str.split("&");
		for (int i = 0; i < arrStr.length; i++) {
			String result=arrStr[i].replaceAll("(.*)=(.*)", "$1"); 
	        System.out.println(result);
		}
		
	}

}
