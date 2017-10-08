package Thread.Basic;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/*
 * 
 * */
public class CaptureUncaughtExceptpion {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newCachedThreadPool(new HandlerThreadFactory());
		executorService.execute(new ExceptionThread());
	}
}

class ExceptionThread implements Runnable{
	
	public void run() {
		Thread thread=Thread.currentThread();
		System.out.println("异常线程开启"+thread);
		System.out.println("run() by"+thread);
		System.out.println("绑定的异常处理器："+thread.getUncaughtExceptionHandler());
		throw new RuntimeException();
		
	}
}

class MyUncachedException implements UncaughtExceptionHandler{
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("异常处理器捕获异常------------------");
		System.out.println(t+"caught"+e);
	}
}

//创建线程工厂存放新建的线程
class HandlerThreadFactory implements ThreadFactory{

	public Thread newThread(Runnable r) {
		System.out.println(this+"新建了一个线程");
		Thread thread=new Thread(r);
		System.out.println("新建的线程是："+thread);
		thread.setUncaughtExceptionHandler(new MyUncachedException());
		return thread;
	}
	
}
