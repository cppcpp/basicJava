package javaDesignpatterns.Adapter;

/*
 * 适配器类，通过这个适配器类使用源类中的方法
 * 这样对外面程序的访问就提供了统一的接口，既可以访问自己的普通方法，也可以访问已经提供的特殊的方法
 * */
public class Adapter extends Adaptee implements Targetable{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("普通类，具有普通的功能");
	}

}
