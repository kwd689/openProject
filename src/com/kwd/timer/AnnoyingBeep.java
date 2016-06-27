/*
 * 文 件 名:  AnnoyingBeep.java
 * 版    权:  MIARTECH (SHANGHAI), INC.
 * 描    述:  <描述>
 * 修 改 人:  wendong.kang
 * 修改时间:  2014-7-9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.kwd.timer;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author wendong.kang
 * @version [MOCO V1.0, 2014-7-9]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AnnoyingBeep {
	Toolkit toolkit;
	Timer timer;
	public AnnoyingBeep() {
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), 0, // initial delay
				1 * 1000); // subsequent rate
	}
	class RemindTask extends TimerTask {
		int numWarningBeeps = 3;
		public void run() {
			if (numWarningBeeps > 0) {
				toolkit.beep();
				System.out.println("Beep!");
				numWarningBeeps--;
			} else {
				toolkit.beep();
				System.out.println("Time's up!");
				// timer.cancel(); //Not necessary because we call System.exit
				System.exit(0); // Stops the AWT thread (and everything else)
			}
		}
	}
	public static void main(String args[]) {
		System.out.println("About to schedule task.");
		new AnnoyingBeep();
		System.out.println("Task scheduled.");
	}
}
