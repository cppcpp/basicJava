package Thread.createThread;

import java.util.concurrent.TimeUnit;
/*
 *用不同的内部类创建线程
 * 1.内部类继承Thread接口
 * 2.内部类实现Runnable接口
 * 3.内部类作为匿名内部类（
 * 		分别继承Thread
 * 		实现Runnable
 * ）
 * 
 * 这里只演示实现Runnable接口的两种方法，继承Thread的写法类似
 * 
 * */
public class ThreadVarious {
	public static void main(String[] args) {
		InnerRunnable1 class1=new InnerRunnable1("线程一");
	}
}

/*
 * 内部类实现Runnable接口
 * 
 * */
class InnerRunnable1{
	private int count=5;
	Inner inner;
	
	public InnerRunnable1(String name){
		Inner inner=new Inner(name);
	}
	
	private class Inner implements Runnable{
		Thread thread;
		public Inner(String name){
			thread=new Thread(this,name);
			thread.start();
		}
		public void run() {
			while(true){
				//this直接调用内部类的toString()方法
				System.out.println(this);
				if(--count==0)
					return;
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public String toString(){
			return thread.getName()+":"+count;
		}
	}
} 


/*
 * 将内部类作为匿名内部类（还是实现Runnable接口）
 * */
class InnerRunnable2{
	private int count=5;
	private Thread t;

	public InnerRunnable2(String name){
		t=new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					System.out.println(this);
					if(count--==0)
						return ;
				}
			}
			
			public String toString(){
				return t.getName()+":"+count;
			}
		},name);
		
		t.start();
	}
	
	
}
