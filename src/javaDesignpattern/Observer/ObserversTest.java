package javaDesignpattern.Observer;
/*
 * 观察者模式
 * 当当前类改变时，通知与它相关联的类进行改变
 * 
 * */
public class ObserversTest {	
	public static void main(String[] args) {
		Observer observer1=new Observer1();
		Observer observer2=new Observer2();
		
		MySubject mySubject=new MySubject();
		mySubject.add(observer1);
		mySubject.add(observer2);
		mySubject.operate();
	}
}
