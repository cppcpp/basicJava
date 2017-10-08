package Chapter14Thread.bounceThread;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class BounceThread {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {

				JFrame frame=new BounceFrame();
				frame.setTitle("¿ªÆôµ¯ÇòÏß³Ì");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
	}
}
