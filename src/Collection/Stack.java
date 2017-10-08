package Collection;

import java.util.LinkedList;

/*
 * 自定的栈
 * LinkedList具有满足栈要求的所有方法，因此可以用LinkedList直接实现栈
 * 
 *不直接继承LinkedList类：因为这样会产生具有LinkedList的其他所有方法的类
 * 
 * */
public class Stack<T> {
	private LinkedList<T> linkedList=null;
	
	public Stack(){
		//linkedList无限大，无法创建一个具有固定大小的linkedList
		linkedList=new LinkedList<>();
	}
	//返回栈低（表头）元素，元素还存在
	public T peek(){
		return linkedList.peek();
	}
	//取出栈顶（表尾）元素，元素取出
	public T pop(){
		return linkedList.poll();
	}
	//加入元素
	public void push(T element){
		linkedList.addFirst(element);
	}
	
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
	
	public int length(){
		return linkedList.size();
	}
	
	//销毁栈
	public void DestroyStack() {
		if(linkedList==null)
			return;
		while(!linkedList.isEmpty()) {
			linkedList.pop();
		}
	}
	
	public String toString(){
		return linkedList.toString();
	}
	
}
