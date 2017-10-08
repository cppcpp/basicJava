package Chapter8Event;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/*
 * ������������¼�
 * 
 * ��Ҫ���ӿڣ�AbstractAction��KeyStroke��InputMap��ActionMap
 * 
 * */
public class ActionFram extends JFrame{
	private JPanel buttonPanel;
	private static int DEFAULT_WIDTH=300;
	private static int DEFAULT_HEIGHT=200;
	//Action�ӿڣ���װ����,���ӵ�����¼�Դ��һ��������һ�����������˵����ִ��������Ҫ�Ĳ��������������е���Ҫ����ɫ��
	//Action�ӿ�����8����Ԥ���嶯��
	//Action�ӿ���չ��ActionListener�ӿ�
	//AbstractAction��ʵ����Action�ӿ��г�actionPerformed������з����������ض�������ʹ��ͬһ����
	//�洢���е���/ֵ ��
	public ActionFram(){
		buttonPanel=new JPanel();
		ColorAction ActionYellow=new ColorAction("Yellow", new ImageIcon("yellow.gif"), Color.yellow);
		ColorAction ActionBlue=new ColorAction("Blue", new ImageIcon("blue.gif"), Color.blue);
		ColorAction ActionRed=new ColorAction("Red", new ImageIcon("red.gif"), Color.red);		
		
		createButton(ActionYellow);
		createButton(ActionBlue);
		createButton(ActionRed);
		
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		this.add(buttonPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//*****************�õ�ͼƬ��Դ
		URL url=this.getClass().getResource("blue.gif");
		this.setIconImage(new ImageIcon(url).getImage());
		
		//InputMap�Ƚ���������KeyStroke��ӳ�䵽���������
		//����ActionMap��ʵ�ֽ�����ӳ�䵽�����ϵĵڶ���ӳ�䣨����Ӧ�ú�����ӳ�������йأ�
		//WHEN_ANCESTOR_OF_FOCUSED_COMPONENT����������������ӵ�м��̽�������ʱ
		InputMap imap=buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		ActionMap amap=buttonPanel.getActionMap();
		amap.put("panel.yellow", ActionYellow);
		amap.put("panel.blue",ActionBlue);
		amap.put("panel.red",ActionRed);
		
	}
	
	public void createButton(Action colorAction){
		JButton button= new JButton(colorAction);
		buttonPanel.add(button);
	}
	
	//�ڲ��ദ���¼�
	public class ColorAction extends AbstractAction{
		
		public ColorAction(String name,Icon icon,Color c){
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue("color",c);
		}
		public void actionPerformed(ActionEvent e) {
			Color bg=(Color) getValue("color");
			buttonPanel.setBackground(bg);
		}
		
	}
	
	public static void main(String[] args) {
		new ActionFram();
	}
}

