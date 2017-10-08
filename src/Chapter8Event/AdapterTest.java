package Chapter8Event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;


/*
 * Java������ģʽ-��������������������
 * �������൱���м���
 * */
public class AdapterTest extends JFrame{
	MyWindowAdapter adapter=new MyWindowAdapter();
	public AdapterTest(){
		this.setTitle("Adapter Test");
		this.setSize(200, 200);
		this.setVisible(true);
		this.addWindowListener(adapter);
	}
	public static void main(String[] args) {
		new AdapterTest();
	}
}

class MyWindowAdapter extends WindowAdapter{
	 public void windowClosing(WindowEvent e) {
		 System.out.println("���ڹر�");
		 System.exit(0);
	 }
}