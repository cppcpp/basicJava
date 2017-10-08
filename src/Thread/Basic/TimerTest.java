package Thread.Basic;

import java.util.Timer;
import java.util.TimerTask;

/*
 * 一个程序可以生成许多Timer对象，这些Timer在时间到达后可以做简单的任务
 * */
public class TimerTest{
	private int count;
	public TimerTest(int count){
		this.count=count;
		Thread thread=new Thread(new Inner());
		thread.start();
	}
	
	class Inner implements Runnable{
		Timer timer;
		public void run() {
			while(true){
				if(count==0)
					return;
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						System.out.println("你好");
					}
				},count*1000);
				count--;
			}
		}
		
	}
	
	public static void main(String[] args) {
		TimerTest test=new TimerTest(5);
		
	}
	
}
