package Chapter14Thread.synchronize;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final double[] accounts;//只能初始化一次
	//保证同步的锁
	private Lock bankLock;
	//条件对象
	private Condition sufficientFunds;
	
	
	//初始化每个账户中的钱
	public Bank(int n,double initalBallBounce){
		accounts=new double[n];
		for(int i=0;i<accounts.length;i++){
			accounts[i]=initalBallBounce;
		}
		
		//初始化银行锁
		bankLock=new ReentrantLock();
		//银行锁的条件对象
		sufficientFunds=bankLock.newCondition();
		
	}
	
	//可以用synchronize关键字
	
	public void transfer(int from ,int to,double amount){
		//线程封锁封锁锁对象
		bankLock.lock();
		
		try {
			while(accounts[from]<amount)
				//余额不足，--调用await(),当前线程阻塞，并放弃了锁
				//进入该条件的等待集，当锁可用时，不能立即解除阻塞，相反，一直处于阻塞知道另一个线程调用singalAll()
				sufficientFunds.await();
			//返回正在执行的线程对象
			System.out.println(Thread.currentThread());
			accounts[from]-=amount;
			System.out.printf("%10.2f from %d to %d",amount,from ,to);
			accounts[to]+=amount;
			System.out.printf("Total balance is %10.2f%n",getTotalBalance());
			
			//唤醒所有等待线程(只是通知正在等待的线程，此时可能满足条件，值得再次去检测条件)
			//WARNNNING-------当一个线程拥有条件锁时，只能调用await,singalAll,singal
			sufficientFunds.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public double getTotalBalance(){
		
		bankLock.lock();
		try{
			double sum=0;
			for(double a:accounts){
				sum+=a;
			}
			return sum;
		}finally{
			bankLock.unlock();
		}
	}
	
	public int size(){
		return accounts.length;
	}
	
}
