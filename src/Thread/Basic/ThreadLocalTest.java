package Thread.Basic;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/*
 * 线程本地变量：对一个共享变量，为每一个线程开辟不同的存储
 * 例如5个线程访问a变量，那线程本地存储就会生成5个用于a的存储块
 * 
 * */
public class ThreadLocalTest {
	public static void main(String[] args) {
		ExecutorService eService=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			eService.execute(new ThreadLocalRunnable(i));
		}
		eService.shutdown();
		try {
			TimeUnit.MICROSECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eService.shutdownNow();
	}
}
class ThreadLocalRunnable implements Runnable{
	private final int id;
	public ThreadLocalRunnable(int id) {
		this.id=id;
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	
	public String toString(){
		return "#"+id+":"+ThreadLocalVariableHolder.get();
	}
}

//类中ThreadLocal类型的value存放产生的值
//increment和get方法都不是同步的，但是ThreadLocal保证了其不会出现竞争条件
class ThreadLocalVariableHolder{
	private static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
		private Random random=new Random(47);
		protected Integer initialValue() {
			return random.nextInt(1000);
		};
	};
	
	public static void increment(){
		value.set(value.get()+1);
	}
	public static int get(){
		return value.get();
	}
	
}
