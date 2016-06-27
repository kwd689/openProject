/*
 * 文 件 名:  ReminderBeep.java
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
 * Simple demo that uses java.util.Timer to schedule a task to execute
 * once 5 seconds have passed.
 * @author wendong.kang
 */
public class ReminderBeep {
	Toolkit toolkit;
	Timer timer;

	public ReminderBeep(int seconds) {
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds * 1000);
	}

	class RemindTask extends TimerTask {
		public void run() {
			System.out.println("Time's up!");
			toolkit.beep();
			// timer.cancel(); //Not necessary because we call System.exit
			System.exit(0); // Stops the AWT thread (and everything else)
		}
	}

	public static void main(String args[]) {
		System.out.println("About to schedule task.");
		new ReminderBeep(5);
		System.out.println("Task scheduled.");
	}
}
