package BasicAndDontKnow;

import java.awt.Component;

import javax.swing.JButton;

/*
 * 新建线程的两种方式：继承Thread类，重写run()
 * 实现Runnable接口，实现run()
 * */
public class TheadTest2 extends Thread{

	public static void main(String[] args) {
		//new新建状态
		Thread thread1= new myThread1();
		Thread thread2= new myThread2();
		Thread thread3=new Thread(new runnable());
		
		//Runnable就绪状态
		//每次执行的是哪个线程是不确定的
		thread1.start();
		//在run方法中有出现可能需要处理的异常
		Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("异常的线程:"+t.getName());
				System.out.printf("异常%s:%sn",e.getClass().getName(),e.getMessage());
				t.start();
			}
		});
		
		thread2.start();
		thread3.start();
		
		/*在线程1中执行Runnable类
		 * 可以看出，执行的是myThread1中的run方法
		 * 原因：Thread也实现了Runnable接口，而run方法也在Runnable接口中实现
		 * 查看源码：Thread类中有target，则执行target的run方法
		 * 　@Override
		    public void run() {
		        if (target != null) {
		            target.run();
		        }
		    }
		    但是例子中的myThread1重写了run方法，因此没有机会执行Thread类中的run方法，而是直接执行了myThread1中的run方法
		 * */
		/*Thread thread1=new myThread1(new runnable());
		thread1.start();
		thread1.interrupt();
		System.out.println("线程当前状态:"+thread1.getState());*/
		
	}

}

class myThread1 extends Thread{
	
	public myThread1(Runnable runnable){
		super(runnable);
	}
	public myThread1(){
		
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("线程名1:"+Thread.currentThread().getName()+"   "+i);
			
				
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(Thread.currentThread().isInterrupted()){
					System.out.println("当前线程被中断");
				}
			
		}
	}
}
class myThread2 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("线程名2:"+Thread.currentThread().getName()+"   "+i);
		}
	}
}
class runnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			
			System.out.println("线程名3："+Thread.currentThread().getName()+"   "+i);
		}
	}
	
}

