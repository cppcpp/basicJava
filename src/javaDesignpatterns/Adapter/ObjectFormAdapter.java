package javaDesignpatterns.Adapter;

/*
 * 对象的适配器模式
 *不采用继承的模式而是采用直接关联，或者成为委托的模式
 *就是适配器类直接持有源类
 * */
public class ObjectFormAdapter implements Targetable{
	//等待适配的类
	private Adaptee adaptee;
	
	public ObjectFormAdapter(Adaptee adaptee){
		this.adaptee=adaptee;
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		//use source class method
		adaptee.method1();
	}

	@Override
	public void method2() {
		System.out.println("这是普通方法");
		
	}
	
	
}
