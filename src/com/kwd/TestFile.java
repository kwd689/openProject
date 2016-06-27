/*
 * 文 件 名:  TestFile.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-2-28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import com.kwd.zip.FileUtils;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  wendong.kang
 * @version  [OEMS V100R002C01, 2014-2-28]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class TestFile {

	/**
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param args
	 * @see [类、类#方法、类#成员]
	 */
	public static void main(String[] args) {
		File file = new File("C:\\");
        File[] files = file.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                // 判断文件名是目录 或 .xls 结尾
                if (pathname.isDirectory() && pathname.getName().toLowerCase().endsWith("users")) {
                    return true;
                }
                return false;
            }});
        List<File> fileList = new ArrayList<File>();
        for (File f : files) {
           File[] files2 = f.listFiles(new FileFilter(){
               @Override
               public boolean accept(File pathname) {
                   // 判断文件名是目录 或 .xls 结尾
                   if (pathname.isDirectory() && pathname.getName().toLowerCase().endsWith("qq")) {
                       return true;
                   }
                   return false;
               }});
           for (int i = 0; i < files2.length; i++) {
        	   File temp = files2[i];
        	   String path = temp.getPath();
               FileUtils.readfile(path,fileList);
		   }
          
        }
        for (File f2 : fileList) {
			System.out.println(f2.getName()+" ### "+f2.getPath());
		}
        int i=5,k;
        k=++i+i--;
        System.out.println(k);
	}
}
