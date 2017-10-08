package Thread.Basic;
/*
 * 演示Thread类中run方法和start方法的区别
 * 
 * start（）源码：
 * start()实际上是通过本地方法start0()启动线程的。而start0()会新运行一个线程，新线程会调用run()方法。
 * 
 * run（）源码：
 * target是一个Runnable对象。run()就是直接调用Thread线程的Runnable成员的run()方法，并不会新建一个线程。
 * */
public class RunAndStrartTest extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is running");
	}
	public static void main(String[] args) {
		Thread thread1=new RunAndStrartTest();
		System.out.println(Thread.currentThread().getName()+" call start()");
		//start开启了一个新的线程
		thread1.start();
		System.out.println(Thread.currentThread().getName()+" call run()");
		//直接调用run方法，运行在main线程上
		thread1.run();
	}
}

