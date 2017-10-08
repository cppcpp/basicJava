package Thread.threadLocal;
/*
 * ThreadLocal实例
 * 
 * 两个线程产生的序号共享一个Test实例，但没有相互干扰，因为通过ThreadLocal为每一个该变量的线程提供独立的变量副本，而不会影响其他其他线程的所对应的副本
 * 
 * 同同步机制（锁）一样，为了解决多线程访问相同变量冲突的问题
 * 同步：以时间换空间            
 * ThreadLocal:以空间换时间
 * 
 * */

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Test {
	private static final ThreadLocal<DateFormat> threadLocal=new ThreadLocal<DateFormat>(){
		
		//返回线程局部变量的初始值
		protected DateFormat initialValue() {
			// TODO Auto-generated method stub
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	
	private static ThreadLocal<Integer> seqNum=new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		}
	}; 
	
	//获取下一个序列值
	public int nextSqlNum(){
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	
	
	public static void main(String[] args) {
		//System.out.println(threadLocal.get().format(new Date()));
		Test test=new Test();
		TestClient testClient=new TestClient(test);
		TestClient testClient1=new TestClient(test);
		testClient.start();
		testClient1.start();
	}
	
	
}

class TestClient extends Thread{
	private Test test;
	public TestClient(Test test) {
		this.test=test;
	}
	
	@Override
	public void run() {
		//打印出三个序列号
		for(int i=0;i<3;i++){
			System.out.println(Thread.currentThread().getName()+"序列号:"+test.nextSqlNum());
		}
	}
}
