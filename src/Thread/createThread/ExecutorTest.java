package Thread.createThread;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {
	public static void cachedThreadPoolTest(){
		// 1.线程池的newCachedThreadPool
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			
				executorService.execute(new LiftOff());
				//sleep()函数的新 
				//TimeUnit.MILLISECONDS.sleep(100);
				//Thread.yield();
		}
	}

	public static void fixedThreadPoolTest() {
		// 2.固定大小的线程池：newFixedThreadPool
		ExecutorService executorService2 = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			executorService2.execute(new LiftOff());
		}
		// shutDown方法：防止其他任务进入Executor。这个程序将在执行完Executor中所有的任务之后退出
		executorService2.shutdown();
	}

	//newSingleThreadExecutor
	public static void singleThreadExecutor(){
		ExecutorService executorService=Executors.newSingleThreadExecutor();
		ArrayList<Future<String>> results=new ArrayList<Future<String>>();
		for(int i=0;i<10;i++){
			//只能通过executorService.submit方法添加Callable
			results.add(executorService.submit(new TaskWithResult(i)));
		}
		for(Future<String> future:results){
			try {
				//get()方法将会被阻塞，直到完成
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
			cachedThreadPoolTest();
			//fixedThreadPoolTest();
			//singleThreadExecutor();
		/*for(int i=0;i<10;i++){
			Thread daemonThread=new Thread(new SimpleDaemon());
			daemonThread.setDaemon(true);
			daemonThread.start();
		}
		System.out.println("all daemon start");
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}

class SimpleDaemon implements Runnable{

	@Override
	public void run() {
				//TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread());
			
	}
	
}