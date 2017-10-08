package Chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
	
	/*
	 * 给任意类型的数组扩容
	 * 不仅仅是对象数组
	 * 因为int[]可以转成Object，但不可以转成对象数组
	 * 
	 * */
	public static void main(String[] args) {
		int[] i={1,2,3};
		i=(int[]) copyOf(i,10);
		System.out.println(Arrays.toString(i));
	}
	
	public static Object copyOf(Object obj, int newLength){
		Class a=obj.getClass();
		if(!a.isArray()){
			return null;
		}
		
		Class component=a.getComponentType();//返回表示数组组件类型的class类，如果不是数组，返回null
		int length=Array.getLength(obj);//Array的静态方法，得到length
		
		Object newArray=Array.newInstance(component, newLength);//构造新的数组
		
		System.arraycopy(obj, 0, newArray, 0, Math.min(length, newLength));
		
		return newArray;
		
		
	}
}
