package Thread.Basic;

/*
 *synchronized同步锁：
 *当一个线程访问”对象“的synchronized方法或同步块，其他线程访问对该对象的同步方法或同步块将会被阻塞
 *
 *比较两种情况的区别
 * */
public class SynchronizedTest2_1 {
	public static void main(String[] args) {
		//synchronized中this是myRunnable对象，对myRunnable访问互斥，必须等myRunnable中全部执行完毕后才能执行
		System.out.println("-----synchronized Runnable");
		myRunnable myRunnable=new myRunnable();
		Thread thread1=new Thread(myRunnable,"thread1");
		Thread thread2=new Thread(myRunnable,"thread2");
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//synchronized中this指Thread对象，新建了两个不同的锁，没有互斥发生
		System.out.println("--------synchronized Thread");
		Thread thread3=new myThread("thread3");
		Thread thread4=new myThread("thread4");
		thread3.start();
		thread4.start();
		
		
	}
}
class myRunnable implements Runnable{
	public void run() {
		synchronized(this){
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName()+"    "+i);
		}
		}
	}
}

class myThread extends Thread{
	public myThread(String name){
		super(name);
	}
	public void run() {
		synchronized(this){
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"    "+i);
			}
			}
	}
}
