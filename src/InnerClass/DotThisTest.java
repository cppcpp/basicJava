package InnerClass;

import InnerClass.DotThis.InnerClass3;

public class DotThisTest {
	public static void main(String[] args) {
		DotThis dotThis=new DotThis();
		
		DotThis.Inner2 inner2=dotThis.new Inner2();
		
		inner2.b++;
		
		//静态内部类
		DotThis.InnerClass3 innerClass3=new InnerClass3();
		
		
	}
}
