package Thread.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * P699练习18：一个非任务的类，中用一个时间较长的sleep方法，在一个任务类中调用这非任务类的方法。在main中，启动这个任务，调用interrupt
 * 方法，确定安全的关闭这个任务
 * 
 * */
public class InterruptTest implements Runnable{
	private SleepClass sleepClass;
	public InterruptTest(SleepClass sleepClass){
		this.sleepClass=sleepClass;
	}
	public void run() {
		sleepClass.SleepMethod();
		System.out.println("安全跳出中断");
	}
	
	public static void main(String[] args) {
		/*ExecutorService service=Executors.newCachedThreadPool();
		service.execute(new InterruptTest(new  SleepClass()));
		service.shutdown();*/
		
		Thread thread=new Thread(new InterruptTest(new SleepClass()));
		thread.start();
		
		thread.interrupt();
	}
}

class SleepClass{
	public void SleepMethod(){
		try {
			TimeUnit.MICROSECONDS.sleep(1000*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("sleep is interrupted");
		}
	}
}