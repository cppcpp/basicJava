package algorithmAndExercise;
/*
 * 栈的应用2：括号匹配、判断是否是平衡符号
 * 
 * 观察输入的字符串是否是平衡符号
 * 
 * */

import Collection.Stack;

public class BracketsMatch {
	Stack<Integer> stack=new Stack<Integer>();
	
	public boolean isMatch(String a) {
		//个数是奇数，肯定不匹配
		if(a.length()%2==1)
			return false;
		
		for(int i=0;i<a.length();i++) {
			//第一次，栈是空的
			if(stack.isEmpty()) {
				stack.push((int)a.charAt(i));
			}else if(a.charAt(i)=='}'&&stack.peek()=='{'||
					a.charAt(i)==']'&&stack.peek()=='['||
					a.charAt(i)==')'&&stack.peek()=='('){
				//匹配，弹出栈顶元素
				stack.pop();
			}else {
				//不匹配，入栈
				stack.push((int)a.charAt(i));
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
		System.out.println(new BracketsMatch().isMatch("{[()]}"));
	}
}
