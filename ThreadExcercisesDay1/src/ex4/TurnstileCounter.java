package ex4;

import java.util.concurrent.locks.ReentrantLock;

public class TurnstileCounter {

	static final long DELAY_VAL = 10000;
	private long count = 0;
	private final ReentrantLock lock = new ReentrantLock();


	public long getValue() {
		return count;
	}

	public void incr() {
		lock.lock();
		//   If the program initially does not fail, replace the count line with the lines below
		//    long n = count;
		//    //Spend some time to force preemtion
		//    for(long a=0; a<LockDemo.DELAY_VAL; a++);
		//    n = n + 1;
		//    count = n;
		try {
			count++;
		} finally {
			lock.unlock();
		}

	}
}
