package Chapter14Thread.bounceThread;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Chapter14Thread.bounce.Ball;
import Chapter14Thread.bounce.BallComponent;

public class BounceFrame extends JFrame{
	private BallComponent comp;
	
	public BounceFrame(){
		comp=new BallComponent();
		add(comp, BorderLayout.CENTER);
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
	
	public void addBall(){
		Ball b=new Ball();
		comp.add(b);
		Runnable r=new BallRunnable(b, comp);
		//实例化线程
		Thread t=new Thread(r);
		//开启线程
		t.start();
	}
}
