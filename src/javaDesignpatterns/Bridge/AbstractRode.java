package javaDesignpatterns.Bridge;

/*
 * 就相当于Bridge类
 * 通过这个接口，实现了对汽车类型的调用
 * 
 * */
public abstract class AbstractRode {
	public AbstractCar car;
	
	public void road(){};
	
}
