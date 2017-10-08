package algorithmAndExercise;

import java.util.Scanner;
import Collection.Stack;;
/*
 * 栈的应用1：进制转换
 * 
 * 十进制转换成八进制
 * */
public class Conversion {
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		System.out.println("输入十进制：");
		Scanner sc=new Scanner(System.in);
		int ten=sc.nextInt();
		
		int remainder=ten;
		while(remainder!=0) {
			stack.push(remainder%8);
			remainder=remainder/8;
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		sc.close();
		
	}
}
