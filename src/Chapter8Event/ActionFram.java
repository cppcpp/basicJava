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
 * 多个动作触发事件
 * 
 * 主要类或接口：AbstractAction，KeyStroke，InputMap，ActionMap
 * 
 * */
public class ActionFram extends JFrame{
	private JPanel buttonPanel;
	private static int DEFAULT_WIDTH=300;
	private static int DEFAULT_HEIGHT=200;
	//Action接口：封装命令,连接到多个事件源。一个动作是一个对象（命令的说明，执行命令需要的参数：例如例子中的需要的颜色）
	//Action接口中有8个个预定义动作
	//Action接口扩展于ActionListener接口
	//AbstractAction：实现了Action接口中除actionPerformed外的所有方法。多个相关动作可以使用同一个类
	//存储所有的名/值 队
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
		//*****************得到图片资源
		URL url=this.getClass().getResource("blue.gif");
		this.setIconImage(new ImageIcon(url).getImage());
		
		//InputMap先将按键对象（KeyStroke）映射到任意对象上
		//再由ActionMap类实现将对象映射到动作上的第二个映射（这样应该和输入映射条件有关）
		//WHEN_ANCESTOR_OF_FOCUSED_COMPONENT：当这个组件包含了拥有键盘焦点的组件时
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
	
	//内部类处理事件
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

