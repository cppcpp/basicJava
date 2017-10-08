package BasicAndDontKnow;

public class Test {
	public int a=1;
	static void b(){
		//静态方法不能引用非静态的变量
		//System.out.println(a);
	}
	
	public static void main(String[] args) {
		b();
		
		Integer integer=null;
		//int i=integer;
		//空指针错误------因为底层int i=integer.intValue()
		//System.out.println(i);
		
		
		//Integer的缓存问题
		//在-127-128之间的数，会缓存
		Integer integer2=100;
		Integer integer3=100;
		Integer integer4=129;
		Integer integer5=129;
		
		System.out.println("Integer: 100=100"+(integer2==integer3));
		System.out.println("Integer 129=129"+(integer4==integer5));
				
	}
	public void a(String a){
		System.out.println("HelloWorld");
	}
	
}
