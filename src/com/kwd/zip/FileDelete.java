/*
 * 文 件 名:  FileDelete.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-2-28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.zip;

import java.util.Timer;

import com.kwd.timer.MyTask;

/**
 * <删除指定路径的文件>
 * 
 * @author  wendong.kang
 * @version  [OEMS V100R002C01, 2014-2-28]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class FileDelete {
    public boolean deleteFile() throws Exception{
    	boolean isfalse = false;
    	String[] paths = new String[4];
        paths[0] = "C:\\Users\\NFC2X00\\AppData\\Roaming\\Tencent\\QQ\\Misc\\com.tencent.advertisement";
        paths[1] = "C:\\Users\\NFC2X00\\AppData\\Roaming\\Tencent\\QQDoctor";
        paths[2] = "C:\\Users\\NFC2X00\\AppData\\Roaming\\Tencent\\Logs";
        paths[3] = "C:\\Users\\NFC2X00\\AppData\\Roaming\\Tencent\\DeskUpdate";
        int successNum = 0;
        for (int i = 0; i < paths.length; i++) {
        	boolean istrue = FileUtils.deleteFile(paths[i]);
        	System.out.println(i+" : "+istrue);
        	if(istrue){
        		successNum++;
        	}
		}
        if(successNum == 4){
        	isfalse = true;
        }
		return isfalse;
    }
	/**
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param args
	 * @throws Exception 
	 * @see [类、类#方法、类#成员]
	 */
	public static void main(String[] args) throws Exception {
		MyTask task = new MyTask();
		Timer timer = new Timer();
		timer.schedule(task, 0, 30*1000);
	}

}
