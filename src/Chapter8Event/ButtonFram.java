package Chapter8Event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * 用内部类组织事件监听
 * 
 * */
public class ButtonFram extends JFrame{
	private static int DEFAULT_WIDTH=300;
	private static int DEFAULT_HEIGHT=200;
	private JPanel buttonPanel;
	
	public static void main(String[] args) {
		new ButtonFram();
	}
	
	public ButtonFram(){
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		/*//新建监听器
		ActionListener listenerBlack=new colorAction(Color.BLACK);
		ActionListener listenerYellow=new colorAction(Color.yellow);
		ActionListener listenerBlue=new colorAction(Color.blue);
		//实例化几个按钮
		JButton buttonBlack=new JButton("Black");
		JButton buttonYellow=new JButton("Yellow");
		JButton buttonBlue=new JButton("Blue");
		//为按钮添加监听
		buttonBlack.addActionListener(listenerBlack);
		buttonYellow.addActionListener(listenerYellow);
		buttonBlue.addActionListener(listenerBlue);
		//创建按钮面板，并将按钮加入面板上
		buttonPanel=new JPanel();
		buttonPanel.add(buttonBlue);
		buttonPanel.add(buttonYellow);
		buttonPanel.add(buttonBlack);
		//将面板添加到Fram框架上
		this.add(buttonPanel);*/
		buttonPanel=new JPanel();
		setButton("Black",Color.BLACK);
		setButton("Yellow",Color.yellow);
		setButton("Blue",Color.blue);
		this.add(buttonPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//color要声明为final,不需要显示的声明构造器，内部类机制会自动生成一个构造器
	public void setButton(String name,final Color bc){
		JButton button=new JButton(name);
		//匿名内部类
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setBackground(bc);
			}
		});
		buttonPanel.add(button);
	}
	/*//用内部类组织
	private class colorAction implements ActionListener{
		private Color pannelColor;
		
		public colorAction(Color color){
			this.pannelColor=color;
		}

		public void actionPerformed(ActionEvent e) {
			buttonPanel.setBackground(pannelColor);
		}
		
	}*/
}

