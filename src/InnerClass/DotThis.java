package InnerClass;


/*
 *想要创建内部类，必须先获得外部类的引用 （嵌套类（静态内部类）除外）
 *生成外部类的引用：.this  .new
 *静态内部类不需要获得对外部类的引用
 * */
public class DotThis {
	
	public void f(){
		System.out.println("DotThis.f()");
	}
	private class Inner{
		public DotThis outer(){
			//获得外部类的引用，直接返回this，是Inner
			return DotThis.this;
		}
	}
	
	public class Inner2{
		private int a=1;
		public int b=2;
	}
	
	public Inner inner(){
		return new Inner();
	}
	
	public void testUseThis(DotThis dotThis) {
		//如果在外围类以外的地方创建内部类，必须这样
		DotThis.Inner inner= dotThis.inner();
		inner.outer().f();
	}
	
	public void testUseNew(DotThis dotThis){
		//.new 获得外部类的引用
		DotThis.Inner2 inner2=dotThis.new Inner2();
	}
	
	//静态内部类不需要获得对外部类的引用
	public static class InnerClass3{
		private int a=0;
		private void a(){
			System.out.println("InnerClass3.a()");
		}
	}
	
	//多层嵌套类使用
	//类被嵌套多少层并不重要，他能透明访问所有外围类信息
	private class A{
		void a(){System.out.println("A.a()");}
		private class AA{
			void aa(){System.out.println("AA.aa()");}
			private class AAA{
				void aaa(){System.out.println("AAA.aaa()");}
			}
		}
	}
	
	
	//用嵌套内部类来测试每个类
	public static class TestDotThis{
		public static void main(String[] args) {
			DotThis dotThis=new DotThis();
			
			dotThis.testUseThis(dotThis);
			dotThis.testUseNew(dotThis);
			
			InnerClass3 innerClass3=new InnerClass3();
			
			innerClass3.a();
			//访问private变量
			System.out.println(innerClass3.a);
			
			//从多层嵌套类中访问外围类
			A a=dotThis.new A();
			a.a();
			DotThis.A.AA aa=a.new AA();
			aa.aa();
			DotThis.A.AA.AAA aaa=aa.new AAA();
			aaa.aaa();
			
			
		}
	}
}
