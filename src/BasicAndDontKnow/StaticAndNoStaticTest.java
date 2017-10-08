package BasicAndDontKnow;

public class StaticAndNoStaticTest {
	public static int a;//step1
	public int b;
	
	//step2
	static{
		System.out.println("静态代码块中a："+a);
	}
	
	//step5
	{
		a=2;
		System.out.println("构造代码块（非静态代码块）中a："+a);
	}
	
	
	public StaticAndNoStaticTest(){
		this("调用有参构造函数："+a);//step3
		System.out.println("无参构造函数在执行");//step8
	}
	
	public StaticAndNoStaticTest(String a){
		this("12","34");//step4
		System.out.println("有参构造函数2在执行，参数是："+a);//step7
	}
	
	public StaticAndNoStaticTest(String s1,String s2){
		System.out.println("构造函数2执行");//step6
	}
	
	public static void main(String[] args) {
		StaticAndNoStaticTest test=null;
		System.out.println("!!!!!!!!!!!!!");
		test=new StaticAndNoStaticTest();
		
	}
}
