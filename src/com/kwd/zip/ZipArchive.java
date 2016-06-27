/*
 * 文 件 名:  ZipArchive.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-2-26
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * <zip压缩文件>
 * 
 * @author  wendong.kang
 * @version  [OEMS V100R002C01, 2014-2-26]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ZipArchive { 
	private static String filePath = "d:\\sql\\2013-09-16.sql";
	private static String outPath ="d:";
	/******
	 * 
	 * <压缩文件>
	 * @param filePath
	 * @param outPath
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public boolean compress(String filePath,String outPath){
		boolean istrue = false;
		try {
				File file = new File(filePath);
				if(file.isFile()){
					InputStream fileIn = new FileInputStream(file);
					int index = file.getName().indexOf(".");
				
					outPath = outPath+file.getName().substring(0, index)+".zip";
					outPath = 	new String(outPath.getBytes("GBK"),"UTF-8");//中文处理
					FileOutputStream fileOut = new FileOutputStream(outPath);
					ZipOutputStream zipOut = new ZipOutputStream(fileOut);
					
					ZipEntry zipEntry = new ZipEntry(file.getName());
					zipOut.putNextEntry(zipEntry);
					byte[] temp = new byte[1024];
					int len = 0;
					while((len = fileIn.read(temp)) != -1){
						zipOut.write(temp,0,len);
					}
					zipOut.close();
					fileOut.close();
					fileIn.close();
					
					istrue = true;
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return istrue; 
	}
	/*******
	 * 
	 * <压缩文件夹>
	 * @param filePath
	 * @param outPath
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public boolean allCompress(String filePath,String outPath){
		boolean istrue = false;
	
		try {
			File file = new File(filePath);
			String filename ="";
			if(file.isDirectory()){
				filename = file.getName();
			}else{
				String name = file.getName();
				int endIndex =name.indexOf(".");
				filename = name.substring(0, endIndex);
			}
			filename=new String(filename.getBytes("GBK"),"UTF-8");
			outPath+=filename+".zip";
			FileOutputStream fileOut = new FileOutputStream(outPath);
			ZipOutputStream zipOut = new ZipOutputStream(fileOut);
			List<File> fileList = new ArrayList<File>();
			FileUtils.readfile(filePath,fileList);
			int num=0;
			for (int i = 0; i < fileList.size(); i++) {
				InputStream fileIn = new FileInputStream(fileList.get(i));
				String tempname = fileList.get(i).getName();
				tempname = new String(tempname.getBytes("GBK"),"UTF-8");
				ZipEntry zipEntry = new ZipEntry(tempname);
				zipOut.putNextEntry(zipEntry);
				byte[] temp = new byte[1024];
				int len = 0;
				while((len = fileIn.read(temp)) != -1){
					zipOut.write(temp,0,len);
				}
				
				fileIn.close();
				num++;
			}
			zipOut.close();
			fileOut.close();
			if(num == fileList.size()){
				istrue = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return istrue;
	}
	public static void main(String[] args) {
		ZipArchive zip = new ZipArchive();
		//boolean istrue=zip.compress(filePath, outPath);
		//System.out.println(istrue);
		//zip.readfile(filePath);
		boolean isfalse = zip.allCompress("d:\\sql", "d:");
		System.out.println(isfalse);
		boolean istrue = zip.releaseZip("d:\\sql.zip", "d:\\123456789");
		System.out.println(istrue);
	}
    /******
     * 
     * <解压zip>
     * @param filePath 源文件地址
     * @param outPath 解压后文件地址
     * @return
     * @see [类、类#方法、类#成员]
     */
    public boolean releaseZip(String filePath,String outPath){
    	boolean istrue = false;
    	
    	if(filePath == null || outPath == null){
    		return istrue;
    	}
    	File file = new File(filePath);
		if(file == null || !file.isFile() || !file.getName().trim().toLowerCase().contains(".zip")){
			return istrue;	
		}
		try {
			ZipFile zipFile = new ZipFile(filePath);
			Enumeration names = zipFile.entries();
			while(names.hasMoreElements()){
				ZipEntry zipEntry = (ZipEntry) names.nextElement();
				if(!zipEntry.isDirectory()){
					InputStream is = zipFile.getInputStream(zipEntry);
					if(is != null){
						String tempname = new String(zipEntry.getName().getBytes("UTF-8"),"GBK");
						String path = outPath+File.separator+tempname;
						File outFile = new File(path);
						if(!outFile.getParentFile().exists()){
							outFile.getParentFile().mkdirs();//创建不存在的路径
						}
						FileOutputStream out = new FileOutputStream(outFile);
						int count=0;
						int bufferSize = 1024;
						byte[] buffer = new byte[bufferSize];
						while((count = is.read(buffer)) !=-1){
							out.write(buffer, 0, count);
						}
						out.flush();
						out.close();
						is.close();
						istrue = true;
					}
				}
			}
			zipFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return istrue;
    }
}
