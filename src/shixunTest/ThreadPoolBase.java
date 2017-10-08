package shixunTest;

/*
 * 1、主线程向子线程传值：构造函数
 * 2.子线程向主线程传值：线程交互：wait（）和notify(),notifyAll()机制
 * 使用wait和notify必须在同步环境下，必须持有同一个对象的锁，通过同一个对象的锁来进行唤醒
 * notify（）：通知和他持有同一个对象锁的被wait（）的线程，解锁*********************
 * 自动解锁****************this.notify()持有当前对象的锁
 * 持有非当前对象锁*****一定要obj.notify()
 * 
 * 
 * sleep():时间结束后，线程自动解锁
 * wait()：一定要去唤醒
 * */
public class ThreadPoolBase {
	public static void main(String[] args) {
		CountRunnable cRunnable=new CountRunnable();
		Thread thread1=new Thread(cRunnable);
		thread1.start();
		synchronized (cRunnable) {
			try {
				cRunnable.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("最终结果："+cRunnable.getSum());
	}
}

class CountRunnable implements Runnable{
	int sum;
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public int getSum(){
		return this.sum;
	}
	@Override
	public void run(){
		synchronized (this) {
			this.notify();
			for(int i=0;i<10;i++){
				sum+=i;
			}
		}
		
	}
	
}
