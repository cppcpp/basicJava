package Thread.Basic;

/*
 * 练习：创建一个类，中有三个方法，包含一块临界区（同步控制块）对该临界区的同步是加在同一个对象上，创建多个任务证明每次只能有一个方法执行
 * */
public class SynchronizeTest {
	Object object=new Object();
	public void a(){
		synchronized(this){
				for(int i=0;i<10;i++){
					System.out.println("a()");
				}
		}
	}
	public void b(){
		synchronized(object){
			
				for(int i=0;i<10;i++){
					System.out.println("b()");
				}
		}
	}
	
	public static void main(String[] args) {
		SynchronizeTest test=new SynchronizeTest();
		Thread thread=new Thread(new Runnable() {
			@Override
			public void run() {
				test.b();
			}
		});
		thread.start();
		test.a();
	}
}

