package com.mckinsey.atm.interceptor;

import java.util.Scanner;

/*
 * This class is responsible for handling the session. 
 * Default timeout is 5 sec.
 */
public class SessionHandler {

	private static final int TIME_OUT = 5; // figure denotes time in sec
	private static volatile boolean timeOut = false;
	private static volatile boolean firstTime = true;
	private static volatile boolean startOperation = true;
	private Thread thread;

	static Object lock = new Object();

	private static long startTime;

	public boolean isTimeOut() {
		return timeOut;
	}

	public void setStartOperation(boolean startOperation) {
		this.startOperation = startOperation;
	}

	public void startTimer() {
		thread = new Thread(new TimerThread());
		thread.start();
	}
	
	public void interrupt(){
		thread.interrupt();
	}

	public void unlock() {
		synchronized (lock) {
			lock.notifyAll();
		}
	}

	public static class TimerThread implements Runnable {
		@Override
		public void run() {
			System.out.println("Thread has been started!!!");
			while (true && !Thread.currentThread().isInterrupted()) {
				if (startOperation) {
					if (firstTime) {
						System.out.println("starting time snapshot captured!!!");
						startTime = System.currentTimeMillis();
						firstTime = false;
					}
					if ((System.currentTimeMillis() - startTime) / 1000 > TIME_OUT) {
						System.out.println("Opertion timeout!!!");
						timeOut = true;
						startOperation = false;
						firstTime = true;
					}
				}
				
			}
		}
	}

	public static void main(String[] args) {

		SessionHandler handler = new SessionHandler();
		handler.startTimer();
		System.out.println("Insert Card: \n Type any word");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		handler.unlock();
		if (handler.isTimeOut())
			System.out.println("Time out happened!!!!!");
		else
			System.out.println("successfully done!!!");
	}
}
