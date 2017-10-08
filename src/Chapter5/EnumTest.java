package Chapter5;

import java.lang.Enum;
import java.util.Scanner;
public class EnumTest {
	public enum Size{SMALL,MEDIUM,LARGE};
	//Size类型的变量只能存储这个类型声明时其中的某一个枚举值，或者null
	//比较时只需要用“==”，永远不需要用equals
	Size s=Size.LARGE;
	
	public static void main(String[] args) {
		//1.返回枚举类型常量
		Size.LARGE.toString();
		//2.将ss设置成Size.small
		Size ss=Enum.valueOf(Size.class, "SMALL");
		//3.返回包含全部枚举值的数组
		Size[] values=Size.values();
		
		
		
		
		Scanner in=new Scanner(System.in);
		System.out.println("please input a Size：(SMALL,MEDIUM,LARGE)：");
		String input=in.next().toUpperCase();
		Size2 s2=Enum.valueOf(Size2.class,input);
		System.out.println("size:"+s2);
		System.out.println("您输入的是："+s2.getAbb());
		if(s2==Size2.LARGE){
			System.out.println("您输入的是LARGESize");
		}
	}
	enum Size2{
		SMALL("S"),MEDIUM("M"),LARGE("L");
		private String abb;
		
		private Size2(String abb){this.abb=abb;}
		public String getAbb(){return abb;}
		
	}
}
