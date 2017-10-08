package shixunTest;

public class Base {
	int a;
	static int b;
	
	public Base(){
		System.out.println("base constrator");
		a=1;
		b=1;
	}
	public void addA(){
		System.out.println("base addA");
		a+=1;
	}
	
	public static void addB(){
		System.out.println("base addB");
		b+=2;
	} 
}
