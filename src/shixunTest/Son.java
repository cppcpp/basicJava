package shixunTest;

/*
 * 方法重写（运行时多态）
 * 在子类继承父类中，方法名相同，返回类型相同，参数列表相同
 * 子类重写方法异常的声明要<=父类
 * 子类重写方法修饰权限>=父类
 * 
 * 方法重载（编译时多态）
 * 在同一个类中，方法名相同，参数列表不同
 * 
 * 静态对象（类方法）
 * 
 * 
 * 当子类和父类有同名变量时，父类的同名变量将不会给子类继承（实际开发，不要有同名变量）
 * 所以：子类继承了父类的所有变量及方法是不准确的
 * */
public class Son extends Base{
	public Son(){
		System.out.println("son constract");
		a=2;
		b=2;
	}
	
	public void addA(){
		System.out.println("son addA");
		a+=3;
	}
	
	public static void addB(){
		System.out.println("son addB");
		
		b+=4;
	}
	
	public void addB(int a){}
	
	public static void main(String[] args) {
		Son son=new Son();
		
		Base base=son;
		
		//调用子类的addA方法
		//运行时多态
		//base.addA();
		
		//调用父类的addB方法，因为addB方法是静态的
		//base.addB();
		
		son.addA();
		
		son.addB();
		
		//System.out.println(base.a);
		//System.out.println(base.b);
		System.out.println(son.a);
		System.out.println(son.b);
	}

}
