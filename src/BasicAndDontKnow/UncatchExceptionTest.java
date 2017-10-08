package BasicAndDontKnow;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncatchExceptionTest {
	public static void main(String[] args) {
		Thread my=new myThread3();
		//未捕获的 异常处理器
		my.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("异常的线程:"+t.getName());
				System.out.printf("异常%s:%sn",e.getClass().getName(),e.getMessage());
				//new myThread3().start();
			}
		});
	}
}

class myThread3 extends Thread{
	public void run() {
		System.out.println(Integer.parseInt("12"));
		System.out.println(Integer.parseInt("we"));
		System.out.println(Integer.parseInt("34"));
	}
}
