package ex1;

public class Task1 {
	
	public Task1() {
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
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum=sum+i;
				System.out.println(sum);
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
		Task1 task = new Task1();
	}

}
