package javaDesignpatterns.Adapter;

/*
 * 使用情况：
 * 有时候实现接口，但不是接口中的所有方法都需要
 * 解决：
 * 用一个抽象类实现该接口，直接和这个抽象类打交道，继承抽象类，实现我们需要的方法
 * */
public abstract class InterfaceFormAdapter implements Targetable{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
	
}
