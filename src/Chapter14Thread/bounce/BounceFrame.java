package Chapter14Thread.bounce;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceFrame extends JFrame{
	private BallComponent comp;
	private static final int STEPS=100;
	private static final int DELAY=3;
	
	public BounceFrame(){
		this.setTitle("弹球测试");
		comp=new BallComponent();
		add(comp,BorderLayout.CENTER);
		JPanel buttonPanel=new JPanel();
		//添加按钮及监听
		addButton(buttonPanel,"start",new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBall();
			}
		});
		
		addButton(buttonPanel, "stop",new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
		
	}

	private void addButton(Container c, String title, ActionListener actionListener) {
		JButton button=new JButton(title);
		c.add(button);
		button.addActionListener(actionListener);
	}
	
	private void addBall(){
		Ball ball=new Ball();
		comp.add(ball);
		
		for(int i=1;i<STEPS;i++){
			try {
				System.out.println(i);
				ball.move(comp.getBounds());
				comp.paint(comp.getGraphics());
				//暂停当前线程的活动
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
