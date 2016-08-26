package fun;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class ThreadView {

	private JFrame frame;
	private final int MAX = 100;
	//private Timer timer;
	//private JProgressBar progressBar;
	private JPanel panel;
	private int threadnumber=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadView window = new ThreadView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ThreadView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);


		JButton btnStart = new JButton("Start");
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				threadnumber++;
				T thread2 = new T();
				thread2.start();
			}
		});
		frame.getContentPane().add(btnStart, BorderLayout.SOUTH);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 120, 5);
		panel.setLayout(fl_panel);
		
		
	}

	private class Action implements ActionListener{
		T thread;
		JProgressBar progressBar;
		JLabel label = new JLabel("Thread"+Integer.toString(threadnumber));
		@SuppressWarnings("deprecation")
		public Action(T thread) {
			progressBar = new JProgressBar();
			panel.add(label);
			panel.add(progressBar);
			frame.show();
			this.thread=thread;
		}
		
		private int counter = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			progressBar.setValue(counter++);
			if(counter>MAX){
				thread.getTimer().stop();
				counter=0;
				progressBar.setValue(0);
				panel.remove(progressBar);
				panel.remove(label);
				threadnumber=0;
				frame.repaint();
			}

		}

	}

	private class T extends Thread{
		private Timer timer = new Timer(1 + (int)(Math.random() * 50),new Action(this));
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			timer.start();
		}
		
		@Override
		public synchronized void start() {
			super.start();
		}
		
		public Timer getTimer(){
			return timer;
		}

	}

}
