package BasicAndDontKnow;

//表达式中类型提升问题
public class Test4 {
	static int i;
	public static void main(String[] args) {
		i++;//自动初始化
		int a=1;
		long b=2;
		int c=(int)(a+b);//二元运算符都会有类型提升
		
		int money=1000000000;//十亿
		int year=20;
		long total=(long)money*year;//必须先转型在运算，否则已经溢出了
		System.out.println(total);
		
	}

	public void a(){
		int a;
		//a=a+1;//局部变量使用前必须声明和初始化
		this.i++;
	}
	
	//静态方法中不能使用this关键字
	public static void b(){
		
	}
}
