package Thread.Basic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
/*
 * 用原子类改装之前的AtomictyTest类，可以不用synchronize和volatile来保证执行的正确性
 * 
 * 原子类：诸如AtomicInteger AtomicDouble AtomicReference
 * 
 * Atomic类被设计用来构建java.util.concurrent包中的类，只有在特殊情况下才在自己的类中使用它，通常依赖锁来解决（synchronize，Lock）
 * 
 * */
public class AtomictyIntegerTest implements Runnable{
	private AtomicInteger i=new AtomicInteger(0);
	public int getValue(){
		return i.get();
	}
	
	public void increment(){
		i.addAndGet(2);
	}
	@Override
	public void run() {
		while(true){
			increment();
		}
	}
	public static void main(String[] args) {
		//程序运行时正确的，用一个定时任务来控制5秒后停止
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.err.println("Aborting");
				System.exit(0);
			}
		}, 5000);
		
		ExecutorService executorService=Executors.newCachedThreadPool();
		AtomictyIntegerTest test=new AtomictyIntegerTest();
		executorService.execute(test);
		
		while(true){
			int val=test.getValue();
			System.out.println(val);
			if(val%2!=0){
				System.out.println(val);
				System.exit(0);
			}
		}
		
	}
	
}
