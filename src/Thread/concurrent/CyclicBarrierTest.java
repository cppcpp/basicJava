package Thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * CycliBarrier用法：
 * 模拟所有写操作完成才能进行下面的操作
 * 
 * */
public class CyclicBarrierTest {
	private static int count=4;
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier=new CyclicBarrier(count, new Runnable() {
			@Override
			public void run() {
				//这里从四个线程中随机抽取一个线程来完成
				System.out.println("所有线程的写入操作已经完成，当前线程是："+Thread.currentThread().getName());
			}
		});
		
		ExecutorService service=Executors.newCachedThreadPool();
		for(int i=0;i<count;i++)
			service.execute(new Writer(cyclicBarrier));
		
		try {
			//阻塞住main线程，让其他线程执行
			TimeUnit.MICROSECONDS.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//CyclicBarrier重用
		System.out.println("重用CylicBarrer-------");
		
		for(int i=0;i<count;i++)
			service.execute(new Writer(cyclicBarrier));
		
	}
}
class Writer implements  Runnable{
	public CyclicBarrier cyclicBarrier;
	public Writer(CyclicBarrier cyclicBarrier){
		this.cyclicBarrier=cyclicBarrier;
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+"写操作开始");
			//sleep模拟写操作
			TimeUnit.MICROSECONDS.sleep(1000);
			System.out.println(Thread.currentThread().getName()+"写操作结束,等待其他线程写操作结束...");
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"线程的写入操作完成");
	}
}