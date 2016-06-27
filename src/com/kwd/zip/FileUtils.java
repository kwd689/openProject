/*
 * 文 件 名:  FileUtils.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-2-27
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.zip;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <File帮助类>
 * 
 * @author  wendong.kang
 * @version  [OEMS V100R002C01, 2014-2-27]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class FileUtils {
	 /**
     * 读取某个文件夹下的所有文件
     */
    public static List<File> readfile(String filePath,List<File> fileList){
          
            if(filePath == null ){
            	return null;
            }
            if(fileList == null){
            	  fileList = new ArrayList<File>();
            }
            File file = new File(filePath);
         
			if (!file.isDirectory()) {
				fileList.add(file);
				//System.out.println(file.getName()+" ## "+file.getPath());
			} else if (file.isDirectory()) {
			        String[] filelist = file.list();
			        if(filelist != null && filelist.length > 0){
			        	 for (int i = 0; i < filelist.length; i++) {
				                File readfile = new File(filePath + "\\" + filelist[i]);
				                if (!readfile.isDirectory()) {
				                	fileList.add(readfile);
				                	//System.out.println(readfile.getName()+" ## "+readfile.getPath());
				                } else if (readfile.isDirectory()) {
				                        readfile(filePath + "\\" + filelist[i],fileList);
				                }
				        }
			        }
			       

			}
            return fileList;
    }
    /*****
	 * 删除文件夹
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteDirectory(File file) throws Exception {
		boolean istrue = false;
		if (file != null && file.exists() && file.isDirectory()) {
			File[] listFile = file.listFiles();
			for (int i = 0; i < listFile.length; i++) {
				if (listFile[i] != null && listFile[i].isFile()) {
					listFile[i].delete();
				} else if (listFile[i] != null && listFile[i].isDirectory()) {
					deleteDirectory(listFile[i]);
				}
			}
			file.delete();
			istrue = true;
		}else if(file != null && file.exists() && file.isFile()){
			file.delete();
			istrue = true;
		}
		return istrue;
	}
	/*****
	 * 根据路径删除文件或文件夹
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteFile(String path) throws Exception {
		boolean istrue = false;
		if (path != null) {
			File f = new File(path);
			if (f != null && f.exists() == true && f.isFile()) {
				f.delete();
				istrue = true;
			} else if (f != null && f.exists() == true && f.isDirectory()) {
				boolean bool = FileUtils.deleteDirectory(f);
				if (bool) {
					istrue = true;
				}
			} else if (f.exists() == false) {
				istrue = true;
			}
		}
		return istrue;
	}

}
