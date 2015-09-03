package com.mckinsey.atm.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * This class is responsible for locking while doing withdraw/deposit operations. 
 */
public class OperationLocks {
    
	private static Lock opertaionLock = new ReentrantLock();
	
	public static void acquireLock(){
		opertaionLock.lock();
	}
	
	public static void releaseLock(){
		opertaionLock.unlock();
	}
}
