package ex2;

//This one is started in the Test class!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class Task3 extends Thread{
	private Thread t;
	private Even even;
	public Task3(Even even) {
		this.even=even;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		if (t == null)
		{
			t = new Thread (this, "");
			t.start ();
		}
	}

	@Override
	public void run() {
		int res;

		res = even.next();
		
		System.out.println(res);

		// TODO Auto-generated method stub

	}

}


