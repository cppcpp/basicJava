package gc;

import java.util.ArrayList;
import java.util.List;


/*
 * 方法区和常量池的内存泄漏
 * 
 * 用string的本次方法intern
 * JDK1.6之前把字符串常量放在永久代（Permanent Generation）中
 * 
 * 限制方法区大小：-XX：MaxPermSize   -XXPerSize
 * 
 * java环境>1.6不会有OutOfMemoryError
 * */
public class RuntimeConstantPoolOOM {
	
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		int i=0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
}
