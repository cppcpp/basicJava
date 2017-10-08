package Chapter8Event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * ���ڲ�����֯�¼�����
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
		/*//�½�������
		ActionListener listenerBlack=new colorAction(Color.BLACK);
		ActionListener listenerYellow=new colorAction(Color.yellow);
		ActionListener listenerBlue=new colorAction(Color.blue);
		//ʵ����������ť
		JButton buttonBlack=new JButton("Black");
		JButton buttonYellow=new JButton("Yellow");
		JButton buttonBlue=new JButton("Blue");
		//Ϊ��ť��Ӽ���
		buttonBlack.addActionListener(listenerBlack);
		buttonYellow.addActionListener(listenerYellow);
		buttonBlue.addActionListener(listenerBlue);
		//������ť��壬������ť���������
		buttonPanel=new JPanel();
		buttonPanel.add(buttonBlue);
		buttonPanel.add(buttonYellow);
		buttonPanel.add(buttonBlack);
		//�������ӵ�Fram�����
		this.add(buttonPanel);*/
		buttonPanel=new JPanel();
		setButton("Black",Color.BLACK);
		setButton("Yellow",Color.yellow);
		setButton("Blue",Color.blue);
		this.add(buttonPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//colorҪ����Ϊfinal,����Ҫ��ʾ���������������ڲ�����ƻ��Զ�����һ��������
	public void setButton(String name,final Color bc){
		JButton button=new JButton(name);
		//�����ڲ���
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setBackground(bc);
			}
		});
		buttonPanel.add(button);
	}
	/*//���ڲ�����֯
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

