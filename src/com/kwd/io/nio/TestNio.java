/*
 * 文 件 名:  TestNio.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-8-11
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author wendong.kang
 * @version [MOCO V1.0, 2014-8-11]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TestNio {
	public static void main(String args[]) throws Exception {

		// String infile = "D:\\workspace\\test\\usagetracking.log";
		// FileInputStream fin= new FileInputStream(infile);
		// FileChannel fcin = fin.getChannel();
		String finUrl = "D:\\sql";
		String foutUrl = "D:\\sql\\test";
		// String fileName = "2013-9-13.sql";
		String fileName = "Ice.Age.2002.BluRay.720p.x264.AC3-WOFEI.mkv";
		// int bufSize = 100;
		File fin = new File(finUrl + File.separator + fileName);
		File fout = new File(foutUrl);
		File fout2 = new File(foutUrl + File.separator + fileName);
		// FileChannel fcin = new RandomAccessFile(fin, "r").getChannel();
		// ByteBuffer rBuffer = ByteBuffer.allocate(bufSize);
		if (!fout.exists()) {
			fout.mkdirs();
		}
		// ByteBuffer wBuffer = ByteBuffer.allocateDirect(bufSize);
		// writeFileByLine(new
		// FileOutputStream(fout+File.separator+fileName).getChannel(), wBuffer,
		// "");
		// FileChannel fcout = new
		// RandomAccessFile(fout+File.separator+fileName, "rws").getChannel();

		newWriteFile(fout2);
		// writeFile(fin,fout2);
		//copeFile(fin, fout2);
		writeFileByWhile(fin, fout2);
		// readFile(fin);
		System.out.print("OK!!!");
	}

	/****
	 * 
	 * 文件读取控制台打印
	 * 
	 * @param inFile
	 * @throws IOException
	 * @see [类、类#方法、类#成员]
	 */
	public static void readFile(File inFile) throws IOException {
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(inFile);
			// FileReader fr = new FileReader(inFile);
			FileChannel inChannel = inputStream.getChannel();
			int tempbyte = -1;
			// 一次读多个字节
			ByteBuffer tempbytes = ByteBuffer.allocate(1024);
			while (inChannel.read(tempbytes) != -1) {
				// 把缓冲中当前位置回复为零，前把缓冲区的 limit 设置为之前 position 值
				tempbytes.flip();
				// 输出缓冲区中的内容
				while (tempbytes.hasRemaining()) {
					System.out.print((char) tempbytes.get());
				}
				tempbytes.clear();
			}
			inChannel.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/***
	 * 
	 * 文件复制（从输入流中直接复制到输出流，一次传送所有的数据,适合小文件复制）
	 * 
	 * @param inFile
	 * @param outFile
	 * @see [类、类#方法、类#成员]
	 */
	public static void writeFile(File inFile, File outFile) {
		try {
			FileInputStream inputStream = new FileInputStream(inFile);
			FileChannel inChannel = inputStream.getChannel();

			FileOutputStream outputStream = new FileOutputStream(outFile);
			FileChannel outChannel = outputStream.getChannel();
			// 连接两个通道，并且从in通道读取，然后写入out通道
			inChannel.transferTo(0, inChannel.size(), outChannel);
			outChannel.close();
			outputStream.close();
			inChannel.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/****
	 * 
	 * 文件复制（从输入流中直接复制到输出流，多次传送所有的数据,适合大文件复制）
	 * 
	 * @param inFile
	 * @param outFile
	 * @throws IOException
	 * @see [类、类#方法、类#成员]
	 */
	public static void writeFileByWhile(File inFile, File outFile)
			throws IOException {
		System.out.println("Start······");
		long startTime = System.currentTimeMillis();
		FileInputStream inputStream = new FileInputStream(inFile);
		FileChannel inChannel = inputStream.getChannel();
		FileOutputStream outputStream = new FileOutputStream(outFile);
		FileChannel outChannel = outputStream.getChannel();
		long writeByte = 0;
		long fileByte = inChannel.size();
		long size =1024 * 1024 * 50;
		/*while (writeByte < fileByte) {
			// 连接两个通道，并且从in通道读取，然后写入out通道
			writeByte += inChannel.transferTo(writeByte, size,outChannel);
		}*/
		while (writeByte < fileByte) {
			// 连接两个通道，并且从in通道读取，然后写入out通道
			writeByte += inChannel.transferTo(writeByte, size,outChannel);
			size = fileByte-writeByte >= size ? size : fileByte-writeByte ;
		}
		outChannel.close();
		outputStream.close();
		inChannel.close();
		inputStream.close();
		System.out.println("用时：" + (System.currentTimeMillis() - startTime)
				/ 1000.0 + "s");
	}

	/****
	 * 
	 * nio缓存文件复制
	 * 
	 * @param inFile
	 * @param outFile
	 * @throws IOException
	 * @see [类、类#方法、类#成员]
	 */
	public static void copeFile(File inFile, File outFile) throws IOException {
		System.out.println("Start······");
		long startTime = System.currentTimeMillis();
		// 获取源文件和目标文件的输入输出流
		FileInputStream fin = new FileInputStream(inFile);
		FileOutputStream fout = new FileOutputStream(outFile);
		// 获取输入输出通道
		FileChannel fcin = fin.getChannel();
		FileChannel fcout = fout.getChannel();
		// 创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 50);
		while (true) {
			// clear方法重设缓冲区，使它可以接受读入的数据
			buffer.clear();
			// 从输入通道中将数据读到缓冲区
			int r = fcin.read(buffer);
			// read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
			if (r == -1) {
				break;
			}
			// flip方法让缓冲区可以将新读入的数据写入另一个通道
			buffer.flip();
			// 从输出通道中将数据写入缓冲区
			fcout.write(buffer);
		}
		fcout.close();
		fcin.close();
		fout.close();
		fin.close();
		System.out.println("用时：" + (System.currentTimeMillis() - startTime)
				/ 1000.0 + "s");
	}

	/****
	 * 
	 * 创建空文件
	 * 
	 * @param file
	 * @throws IOException
	 * @see [类、类#方法、类#成员]
	 */
	public static void newWriteFile(File file) throws IOException {
		String parentPath = file.getParent();
		File parentFile = new File(parentPath);
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
		FileOutputStream outputStream = new FileOutputStream(parentPath
				+ File.separator + file.getName());
		FileChannel channel = outputStream.getChannel();
		ByteBuffer rBuffer = ByteBuffer.allocate(1024);
		channel.write(rBuffer);
		channel.close();
		outputStream.close();
	}
}
