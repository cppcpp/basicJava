package InnerClass;

public class MyInrement {
	public void increment(){System.out.println("另一种操作");}
	//自己类调用自己的方法
	public static void f(MyInrement myInrement){myInrement.increment();} 
}
