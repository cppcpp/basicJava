package InnerClass;

/*
 * 第一种：简单实现接口
 * */
public class Callee1 implements Incrementable{
	private int i=0;
	@Override
	public void increment() {
		i++;
		System.out.println(i);
	}
	
}
