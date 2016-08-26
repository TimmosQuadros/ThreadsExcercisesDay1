package ex1;


public class Task2 {
	
	public Task2() {
		Sum t1  =new Sum();
		Sum t2  =new Sum();
		Sum t3  =new Sum();
		t1.start();
		t2.start();
		t3.start();
	}
	
	private class Sum extends Thread{
		
		@Override
		public void run() {
			for (int i = 1; i <= 5; i++) {
				try {
					Thread.sleep(2000);
					System.out.println(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			super.run();
		}
		
		@Override
		public synchronized void start() {
			// TODO Auto-generated method stub
			super.start();
		}
		
	}
	
	public static void main(String[] args) {
		Task2 task = new Task2();
	}

}
