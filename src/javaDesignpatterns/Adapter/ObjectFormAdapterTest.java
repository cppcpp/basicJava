package javaDesignpatterns.Adapter;

/*对象的适配模式
 * */
public class ObjectFormAdapterTest {
	public static void main(String[] args) {
		Adaptee adaptee=new Adaptee(); 
		Targetable targetable=new ObjectFormAdapter(adaptee);
		targetable.method1();
		targetable.method2();
	}
}
