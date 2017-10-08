package javaDesignpatterns.Singleton;

/*
 * 线程同步访问即时加synchronized关键字也存在的问题-
 * instance=new Singleton();//这部分是两步：创建对象，赋值；但是JVM并不保证这两部的执行顺序：
 * 可能先给新的Singleton分配空间，然后直接赋值给instance成员，然后再初始化Singleton
 * 
 * 所以，使用内部类：内部类执行时，jvm保证每个线程执行类的时候是互斥的。
 * */
public class Singleton {
	//延迟加载（懒加载）（懒汉式）
	public static Singleton instance=null;
	
	//私有的构造方法，防止被实例化
	private Singleton(){
	}
	
	public static Singleton getInstance(){
		if(instance==null){
			synchronized (instance) {
				instance=new Singleton();
			}
		}
		return instance;
	}
}
