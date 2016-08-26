package ex2;

public class Test {
	public static void main(String[] args) throws InterruptedException  {
		final int NOOFTHREADS = 100;
		Even e = new Even();
		Task3[] threads = new Task3[NOOFTHREADS];
		for (int i = 0; i < NOOFTHREADS; i++) {
			threads[i] = new Task3(e);
			threads[i].start();
			threads[i].join();
		}
		
		
		
		
	}
}
