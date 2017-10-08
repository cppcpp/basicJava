package javaDesignpattern.Observer;

public class MySubject extends AbstractSubject{

	@Override
	public void operate() {
		System.out.println("执行operate方法时通知所有的观察者");
		this.notifyAllObservers();
	}

}
