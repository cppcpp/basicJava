package Chapter9Conponent;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class JMenuFram  extends JFrame{
	public JMenuFram(){
		Action exitAction;
		JFrame menuFrame=new JFrame();
		//设置为边框布局
		menuFrame.setLayout(new BorderLayout());
		
		//菜单栏放菜单，菜单中放子菜单
		JMenuBar menuBar=new JMenuBar();
		//”edit“菜单
		JMenu editMenu=new JMenu("Edit");
		menuBar.add(editMenu);		
		JMenuItem fontItem=new JMenuItem("Font");
		editMenu.add(fontItem);
		JMenuItem pastItem=new JMenuItem("Past");
		editMenu.add(pastItem);
		
		//将Add子菜单添加入编辑菜单，方法返回一个JMenuItem,可以对其添加监听(匿名内部类)
		JMenuItem addMenu= editMenu.add("Add");
		addMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		//editMenu.addSeparator();
		
		//"help"menu
		JMenu helpMenu=new JMenu("help");
		menuBar.add(helpMenu);
		JMenuItem welcomeItem= helpMenu.add("Welcome");
		JMenuItem contentItem=helpMenu.add("HelpContent");
		//菜单中的图标
		//JMenuItem iconItem=new JMenuItem("icon", new ImageIcon("blue.gif"));
		//new ImageIcon(String Filename)并不能定位到图片资源
		URL url=this.getClass().getResource("red.gif");
		Icon icon=new ImageIcon(url);
		
		//图标上添加事件
		//JMenuItem iconItem=new JMenuItem("icon", icon);
		//helpMenu.add(iconItem);
		//上面这种方法并不能将事件绑定图标
		
		Action IconAction=new AbstractAction("icon") {
			public void actionPerformed(ActionEvent e) {
				System.out.println("图标的测试事件");
			}
		};
		//将此图标存储到动作对象中
		IconAction.putValue(Action.SMALL_ICON, icon);
		//将动作对象存储在菜单中
		helpMenu.add(IconAction);
		
		
		//File menu
		JMenu fileMenu=new JMenu("File");
		menuBar.add(fileMenu);
		//定义动作：定义一个实现Action接口的类
		exitAction=new AbstractAction("exit") {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		//一下两句可以简写成----JMenuItem exitItem2= fileMenu.add(exitAction);
		JMenuItem exitItem=new JMenuItem(exitAction);
		fileMenu.add(exitItem);
		
		//设置快捷键
		JMenuItem aboutItem=new JMenuItem("About", 'A');
		fileMenu.add(aboutItem);
		
		//pop-up menu
		//没有标题
		JPopupMenu popup=new JPopupMenu();
		popup.add(IconAction);
		popup.add("helpItem1");
		//must use show() method to show the popupMenu
		JPanel panel=new JPanel();
		//pop-up trigger弹出式触发器：windows和Linux中的pop-uptrigger是鼠标右键
		panel.setComponentPopupMenu(popup);
		
		
		
		
		//将menuBar放在Fram的北边
		menuFrame.add(menuBar, BorderLayout.NORTH);
		menuFrame.add(panel,BorderLayout.CENTER);
		menuFrame.setVisible(true);
		menuFrame.setSize(300, 500);
		//设置fram的图标
		System.out.println(url.toString());
		//用getImage()读取，声音用getAudioClip()
		Image image=new ImageIcon(url).getImage();
		menuFrame.setIconImage(image);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new JMenuFram();
	}
}
