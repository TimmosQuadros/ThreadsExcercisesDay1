package fun;

public class ThreadDemo {

	public static void main (String [] args)
	{
		MyThread[] mt = new MyThread[10];
		
		for (int i = 0; i < mt.length; i++) {
			mt[i] = new MyThread();
			mt[i].start();
		}
	}
}
class MyThread extends Thread
{
	int x;
	public void run ()
	{
		x++;
		
		System.out.println("x: "+x);
	}

}
