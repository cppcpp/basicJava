package Chapter6;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {

	public static void main(String[] args) {
			/*TalkingClock tc=new TalkingClock(1000,true);
			tc.start();*/
		
			
			TalkingClock tc=new TalkingClock();
			tc.start(1000, true);
			
			JOptionPane.showMessageDialog(null, "Quite");
			System.exit(0);
	}
}

/*class TalkingClock{
	private int interval;
	private boolean beep;
	
	public TalkingClock(int interval, boolean beep) {
		super();
		this.interval = interval;
		this.beep = beep;
	}
	
	public void start(){
		ActionListener listener=new TimePrint();
		Timer time=new Timer(interval, listener);
		time.start();
	}
	
	public class TimePrint implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Date now=new Date();
			System.out.println("The time is "+now);
			if(beep)
				Toolkit.getDefaultToolkit().beep();
		}
		
	} 
}*/

/*
 * 局部内部类
 * 
 * 省去多余的变量
 * 内部类可以访问局部变量，但是局部变量必须声明为final类型
 * 因为TimePrint类在beep释放之前对其做了一个备份
 * */
/*class TalkingClock{
	public void start(int interval,final boolean beep){
		
		 class TimePrint implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				Date now=new Date();
				System.out.println("The time is "+now);
				if(beep)
					Toolkit.getDefaultToolkit().beep();
			}
			
		} 
		
		ActionListener listener=new TimePrint();
		Timer time=new Timer(interval, listener);
		time.start();
	}
}*/

/*
 *匿名内部类
 *
 * 
 * 
 * */
class TalkingClock{
	public void start(int interval,final boolean beep){
		
		ActionListener listener=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date now=new Date();
				System.out.println("The time is "+now);
				if(beep)
					Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer time=new Timer(interval, listener);
		time.start();
	}
}