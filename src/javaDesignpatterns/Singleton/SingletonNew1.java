package javaDesignpatterns.Singleton;

public class SingletonNew1 {
	private SingletonNew1(){}
	
	//使用内部类
	private static class SingletonFactory{
		//保证instance只被创建一次
		private static SingletonNew1 instance=new SingletonNew1();
	}
	
	public static SingletonNew1 getInstance(){
		
		return SingletonFactory.instance;
	}
}
