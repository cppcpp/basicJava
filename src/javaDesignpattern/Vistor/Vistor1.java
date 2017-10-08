package javaDesignpattern.Vistor;

public class Vistor1 implements Vistor{
	@Override
	public void vistor(Subject subject) {
		System.out.println("访问subject："+subject.getSubject());
	}
	
}
