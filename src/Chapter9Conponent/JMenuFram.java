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
		//����Ϊ�߿򲼾�
		menuFrame.setLayout(new BorderLayout());
		
		//�˵����Ų˵����˵��з��Ӳ˵�
		JMenuBar menuBar=new JMenuBar();
		//��edit���˵�
		JMenu editMenu=new JMenu("Edit");
		menuBar.add(editMenu);		
		JMenuItem fontItem=new JMenuItem("Font");
		editMenu.add(fontItem);
		JMenuItem pastItem=new JMenuItem("Past");
		editMenu.add(pastItem);
		
		//��Add�Ӳ˵������༭�˵�����������һ��JMenuItem,���Զ�����Ӽ���(�����ڲ���)
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
		//�˵��е�ͼ��
		//JMenuItem iconItem=new JMenuItem("icon", new ImageIcon("blue.gif"));
		//new ImageIcon(String Filename)�����ܶ�λ��ͼƬ��Դ
		URL url=this.getClass().getResource("red.gif");
		Icon icon=new ImageIcon(url);
		
		//ͼ��������¼�
		//JMenuItem iconItem=new JMenuItem("icon", icon);
		//helpMenu.add(iconItem);
		//�������ַ��������ܽ��¼���ͼ��
		
		Action IconAction=new AbstractAction("icon") {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ͼ��Ĳ����¼�");
			}
		};
		//����ͼ��洢������������
		IconAction.putValue(Action.SMALL_ICON, icon);
		//����������洢�ڲ˵���
		helpMenu.add(IconAction);
		
		
		//File menu
		JMenu fileMenu=new JMenu("File");
		menuBar.add(fileMenu);
		//���嶯��������һ��ʵ��Action�ӿڵ���
		exitAction=new AbstractAction("exit") {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		//һ��������Լ�д��----JMenuItem exitItem2= fileMenu.add(exitAction);
		JMenuItem exitItem=new JMenuItem(exitAction);
		fileMenu.add(exitItem);
		
		//���ÿ�ݼ�
		JMenuItem aboutItem=new JMenuItem("About", 'A');
		fileMenu.add(aboutItem);
		
		//pop-up menu
		//û�б���
		JPopupMenu popup=new JPopupMenu();
		popup.add(IconAction);
		popup.add("helpItem1");
		//must use show() method to show the popupMenu
		JPanel panel=new JPanel();
		//pop-up trigger����ʽ��������windows��Linux�е�pop-uptrigger������Ҽ�
		panel.setComponentPopupMenu(popup);
		
		
		
		
		//��menuBar����Fram�ı���
		menuFrame.add(menuBar, BorderLayout.NORTH);
		menuFrame.add(panel,BorderLayout.CENTER);
		menuFrame.setVisible(true);
		menuFrame.setSize(300, 500);
		//����fram��ͼ��
		System.out.println(url.toString());
		//��getImage()��ȡ��������getAudioClip()
		Image image=new ImageIcon(url).getImage();
		menuFrame.setIconImage(image);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new JMenuFram();
	}
}
