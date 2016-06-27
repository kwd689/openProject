/*
 * 文 件 名:  Test.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-8-22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  wendong.kang
 * @version  [MOCO V1.0, 2014-8-22]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Test {

	/**
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param args
	 * @see [类、类#方法、类#成员]
	 */
	public static void main(String[] args) {
		double i = Math.floor(5.4);
		double a = Math.round(5.4);
		double b = Math.ceil(5.0000000000001);
         System.out.println(i+"\n"+a+"\n"+b);
	}

}
