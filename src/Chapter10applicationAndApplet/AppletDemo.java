package Chapter10applicationAndApplet;

import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AppletDemo extends JApplet{
	public void init(){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JLabel label=new JLabel("Hello Applet",SwingConstants.CENTER);
				add(label);
			}
		});
	} 
}
