package javaDesignpatterns.Singleton;

/*
 * 单例模式
 * */
public class SongletonTest {
	public static void main(String[] args) {
		SingletonNew2 test1= SingletonNew2.getInstance();
		SingletonNew2 test2= SingletonNew2.getInstance();
		System.out.println(test1==test2);
	}
}
