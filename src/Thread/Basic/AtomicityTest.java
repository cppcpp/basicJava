package Thread.Basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 用synchronize来修复程序，证明其实安全的
 * */
public class AtomicityTest implements Runnable{
	private volatile int i=0;
	
	//return i是原子性的操作，但是缺少同步使其数值在不稳定的中间状态被获取
	public synchronized int getValue(){
		return i;
	}
	
	//此方法肯定是要同步的
	//i++是非原子性的操作，因此要将i设为volatile域，每次增加都刷新到内存中，保证可视性
	private synchronized void evenIncrement(){
		i++;
		i++;
	}
	public void run() {
		while(true){
			evenIncrement();
		}
	}
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newCachedThreadPool();
		AtomicityTest auTest=new AtomicityTest();
		executorService.execute(auTest);
		
		
		while(true){
			int val=auTest.getValue();
			System.out.println(val);
			//如果上面运行正确的话，不可能出现奇数
			if(val%2!=0){
				System.out.println(val);
				System.exit(0);
			}
		}
	}
	
}
