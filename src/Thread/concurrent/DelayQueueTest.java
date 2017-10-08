package Thread.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
 * DelayQueue:
 * implements Delayed接口的类放在DelayQueue中，只有达到类规定的时间，才能从DelayQueue中通过take（）方法取出，否则，take（）阻塞
 * 队列有序：即对头对象的延迟时间最长
 * 
 * 
 * 创建一个Delayed，达到delay时间后从DelayedQueue中去除
 * 从结果中可以看出：：任务创建的顺序和执行顺序没有区别，执行时按照期望顺序执行的~~~
 * */
public class DelayQueueTest {
	public static void main(String[] args) {
		DelayQueue<DelayedTask> queue=new DelayQueue<>();
		ExecutorService service=Executors.newCachedThreadPool();
		Random random=new Random();
		for(int i=0;i<10;i++){
			//随机延迟1~5000之间的数
			queue.put(new DelayedTask(random.nextInt(5000)));
		}
		//创建内部类（非静态）---先创建外部类对象的引用，在用.new语法 创建
		DelayedTask delayedTask=new DelayedTask(random.nextInt(5000));
		queue.add(delayedTask.new StopSentinel(random.nextInt(5000), service));
		service.execute(new DelayTaskComsumer(queue));
	}
}

class DelayedTask implements Delayed,Runnable{
	private static int count=0;
	private final int id=count++;
	//泛型中使用this？？
	private static List<DelayedTask> delays=new ArrayList<DelayedTask>();
	private int delay;
	private long trigger;
	
	public DelayedTask(int delay) {
		this.delay=delay;
		trigger=System.currentTimeMillis()+delay;
		delays.add(this);
	}
	@Override
	public int compareTo(Delayed o) {
		DelayedTask that=(DelayedTask) o;
		return (that.trigger<trigger)?1:-1;
	}

	@Override
	public void run() {
		System.out.println("从DelayQueue中取出到时队列："+this+"  ");
	}
	@Override
	public long getDelay(TimeUnit unit) {
		return trigger-System.currentTimeMillis();
	}
	
	public String toString(){
		return "["+id+"]  Task   delay:"+delay;
	}
	
	//内部类，用于创建一个停止的DelayedTask
	class StopSentinel extends DelayedTask{
		ExecutorService service;
		public StopSentinel(int delay,ExecutorService service) {
			super(delay);
			//System.out.println("加入死亡对象");
			this.service=service;
		}
		
		@Override
		public void run() {
			System.out.println("死亡对象到时：："+this+"  ");
			for(DelayedTask delayedTask:delays){
				System.out.println(delayedTask.toString());
			}
			System.out.println("---call shutDownNow");
			service.shutdownNow();
		}
	}
}

class DelayTaskComsumer implements Runnable{
	private DelayQueue<DelayedTask> delayQueue;
	public DelayTaskComsumer(DelayQueue<DelayedTask> delayQueue){
		this.delayQueue=delayQueue;
	}
	public void run() {
		while(!Thread.interrupted()){
			try {
				delayQueue.take().run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
