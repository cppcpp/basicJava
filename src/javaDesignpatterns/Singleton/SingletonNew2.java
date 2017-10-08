package javaDesignpatterns.Singleton;

/*
 * 第二种实现方式：将创建类的语句单独用synchronized加锁，和getInstance方法分开
 * */
public class SingletonNew2{
	private static SingletonNew2 instance=null;
	
	public static SingletonNew2 getInstance(){
		if (instance==null) {
			createSington();
		}
		return instance;
	}
	
	public static synchronized void createSington(){
		if (instance==null) {
			instance=new  SingletonNew2();
		}
		
	}
}
