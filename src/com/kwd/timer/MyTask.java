package com.kwd.timer;

import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

import com.kwd.zip.FileDelete;



/*******
 * java定时器自定义任务
 * 
 * @author wendong.kang
 * @since 2013-4-9
 */
public class MyTask extends TimerTask {
	private static boolean isRunning = false;

	public MyTask() {
		
	}

	@Override
	public void run() {
		if (!isRunning) {
			isRunning = true;
			try {
				FileDelete fd = new FileDelete();
				fd.deleteFile();
				System.out.println("执行了一次定时器："+new Timestamp(System.currentTimeMillis()));
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("操作失败了：" + e.getMessage());
			}
			isRunning = false;
			System.out.println("指定任务执行结束!");
		} else {
			System.out.println("上次任务还没有执行完毕！");
		}
	}
	public static void main(String[] args) {
		Timer timer = new Timer(true);
		timer.schedule(new MyTask(), 0, 60*1000);
	}
}
