package Chapter14Thread.synchronize;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final double[] accounts;//ֻ�ܳ�ʼ��һ��
	//��֤ͬ������
	private Lock bankLock;
	//��������
	private Condition sufficientFunds;
	
	
	//��ʼ��ÿ���˻��е�Ǯ
	public Bank(int n,double initalBallBounce){
		accounts=new double[n];
		for(int i=0;i<accounts.length;i++){
			accounts[i]=initalBallBounce;
		}
		
		//��ʼ��������
		bankLock=new ReentrantLock();
		//����������������
		sufficientFunds=bankLock.newCondition();
		
	}
	
	//������synchronize�ؼ���
	
	public void transfer(int from ,int to,double amount){
		//�̷߳�������������
		bankLock.lock();
		
		try {
			while(accounts[from]<amount)
				//���㣬--����await(),��ǰ�߳�����������������
				//����������ĵȴ�������������ʱ��������������������෴��һֱ��������֪����һ���̵߳���singalAll()
				sufficientFunds.await();
			//��������ִ�е��̶߳���
			System.out.println(Thread.currentThread());
			accounts[from]-=amount;
			System.out.printf("%10.2f from %d to %d",amount,from ,to);
			accounts[to]+=amount;
			System.out.printf("Total balance is %10.2f%n",getTotalBalance());
			
			//�������еȴ��߳�(ֻ��֪ͨ���ڵȴ����̣߳���ʱ��������������ֵ���ٴ�ȥ�������)
			//WARNNNING-------��һ���߳�ӵ��������ʱ��ֻ�ܵ���await,singalAll,singal
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
