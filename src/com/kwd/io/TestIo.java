/*
 * 文 件 名:  TestIo.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-8-21
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * io流测试
 * @author  wendong.kang
 * @version  [ V1.0, 2014-8-21]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class TestIo {
    public static void main(String[] args) throws IOException {
    	String inFilePath="D:\\sql";
  	    String outFilePath="D:\\sql\\test";
  	    String fileName = "Ice.Age.2002.BluRay.720p.x264.AC3-WOFEI.mkv";
  	    File inFile = new File(inFilePath+File.separator+fileName); 
	    File ourFileUrl = new File(outFilePath); 
	    File ourFile = new File(outFilePath+File.separator+fileName);
	    if(!ourFileUrl.exists()){
	    	ourFileUrl.mkdirs();
	    }
  	    TestIo.writeFile(inFile, ourFile);
	}
	public static void writeFile(File inFile,File outFile) throws IOException{
		   System.out.println("start..");
	        long start = System.currentTimeMillis();
	        int buffersize = 1024 * 1024 * 50;
	        InputStream isInputStream = new FileInputStream(inFile);
	        OutputStream outputStream = new FileOutputStream(outFile);
	        byte[] buffer = new byte[buffersize];
	        int readCount = 0;
	        while ((readCount = isInputStream.read(buffer, 0, buffersize)) > 0) {
	            // System.out.println(readCount);
	            outputStream.write(buffer, 0, readCount);
	        }
	        outputStream.close();
	        isInputStream.close();
	        System.out.println("end.." + (System.currentTimeMillis() - start) / 1000.0 + "s");
	}
}
