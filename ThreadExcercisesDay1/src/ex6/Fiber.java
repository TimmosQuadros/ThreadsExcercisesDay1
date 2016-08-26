package ex6;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fiber extends Thread{
	private JLabel label;
	private JFrame frame;
	public Fiber(JLabel label, JFrame frame) {
		this.label=label;
		this.frame = frame;
	}
	
	@Override
	public void run() {
		for (int i = 20; i >= 0; i--) {
			label.setText("Remain: "+i);
			frame.show();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

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
