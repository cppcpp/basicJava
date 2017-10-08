package javaDesignpattern.Vistor;

/*
 * 访问者模式，分离数据结构和访问行为
 * */
public class VsitorTest {
	public static void main(String[] args) {
		Vistor vistor=new Vistor1();
		Subject subject=new MySubject();
		
		subject.accept(vistor);
		
	}
}
