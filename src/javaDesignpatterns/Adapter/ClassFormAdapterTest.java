package javaDesignpatterns.Adapter;

/*
 * 类的适配器模式
 * 因为源类（等待适配的类）与适配器类是继承关系，所以叫类的适配器模式
 * 
 * */
public class ClassFormAdapterTest {
	public static void main(String[] args) {
		Targetable targetable=new  Adapter();
		targetable.method1();
		targetable.method2();
	}
}
