package shixunTest;
/*
 * synchronize能够锁住的前提条件：线程必须持有同一个对象的锁
 *
 *
 *多个线程执行时无序的，是由jvn决定
 *作用是安全操作，但性能降低
 *缺陷：锁定的范围太大----------因此，提出用synchronize同步块进行安全操作（锁定范围更小，尽量在降低性能的损耗）
 *
 * 同步块中的（）必须是引用对象，不能使基本参数类型
 * 
 * */
public class ThreadTest1 extends Thread{

	//synchronize能够锁住的前提条件：线程必须持有同一个对象的锁
	public  void run() {
		Integer j=0;
		synchronized (j) {
			for(int i=0;i<10;i++){
				System.out.println(Thread.currentThread().getName()+"  "+i);
			}	
		}
	}
}

class ThreadTest2 implements Runnable{

	@Override
	public void run() {
		
		System.out.println("欢迎:"+Thread.currentThread().getName());
		synchronized (this) {
			for(int i=0;i<10;i++){
				System.out.println(Thread.currentThread().getName()+"  "+i);
			}
		}
		
	}
}

class Test{
	public static void main(String[] args) {
		
		ThreadTest1 thread1=new ThreadTest1();
		ThreadTest1 thread2=new ThreadTest1();
		thread1.start();
		thread2.start();
		
		/*ThreadTest2 threadTest2=new ThreadTest2();
		new Thread(threadTest2).start();
		new Thread(threadTest2).start();*/
		
	}
}