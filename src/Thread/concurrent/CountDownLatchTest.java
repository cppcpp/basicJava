package Thread.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * CountDownLatch：
 * 同步多任务，将当前任务阻塞，直到其他任务完成才有机会执行
 * */
public class CountDownLatchTest {
	private static int size=2;
	public static void main(String[] args) {
		
		ExecutorService service=Executors.newCachedThreadPool();
		CountDownLatch countDownLatch=new  CountDownLatch(size);
		for(int i=0;i<2;i++)
			service.execute(new WaitThread(countDownLatch));
		for(int i=0;i<size;i++)
			service.execute(new TaskThread(countDownLatch));
		try {
			TimeUnit.MICROSECONDS.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class WaitThread implements Runnable{
	private CountDownLatch countDownLatch;
	//代表当前任务的编号
	private static int count=0;
	private static final int id=count++;

	public WaitThread(CountDownLatch countDownLatch){
		this.countDownLatch=countDownLatch;
	}
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+"等待所有的TaskThread执行完毕。。。。。");
			//执行时阻塞自己，直到所有的任务线程完成
			countDownLatch.await();
			System.out.println(Thread.currentThread().getName()+"第"+id+"个 等待线程执行完毕");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("WaitTHread interrupted");
		}
		
	}
}
class TaskThread implements Runnable{
	private CountDownLatch countDownLatch;
	private static int count=0;
	private final int id=++count;
	
	public TaskThread(CountDownLatch countDownLatch){
		this.countDownLatch=countDownLatch;
	}
	
	public void run() {
		doWork();
		//每次减少1，减少到0时，就可以执行 等待线程了 
		countDownLatch.countDown();
		
	}
	//模拟任务线程执行任务
	public void doWork(){
		try {
			System.out.println(Thread.currentThread().getName()+"第"+id+"个TaskThread正在执行。。。");
			TimeUnit.MILLISECONDS.sleep(2000);
			System.out.println(Thread.currentThread().getName()+"第"+id+"个任务线程执行完毕");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("TaskThread  is interrupted");
		}
		
	}
}

