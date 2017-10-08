package Thread.DemoThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class DaemonFromFactory implements Runnable{

	@Override
	public void run() {
		try {
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread());
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		ExecutorService service=Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<5;i++)
			service.execute(new DaemonFromFactory());
		
		System.out.println("all daemon started");
		try {
			TimeUnit.MILLISECONDS.sleep(99);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
