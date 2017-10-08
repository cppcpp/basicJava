package Chapter14Thread.bounceThread;

import java.awt.Component;

import Chapter14Thread.bounce.Ball;

public class BallRunnable implements Runnable{
	private Ball ball;
	private Component component;
	public static final int STEPS=1000;
	public static final int DELAY=5;
	
	public BallRunnable(Ball aBall,Component acomponent) {
		ball=aBall;
		component=acomponent;
	}
	
	
	
	@Override
	public void run() {
		for(int i=0;i<=STEPS;i++){
			try {
				ball.move(component.getBounds());
				component.repaint();
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
		}
		
	}

}
