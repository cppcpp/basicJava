package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayListTest extends LinkedList{
	public static void main(String[] args) {
		Integer[] i={1,2,3};
		Collection<Integer> collection=new ArrayList<>(Arrays.asList(i));
		Collections.addAll(collection,4,5,6);
		collection.addAll(Arrays.asList(7,8,9));
		System.out.println(collection);
		
		//得到Arrays的内部类
		Class[] classes= Arrays.class.getDeclaredClasses();
		for(Class c:classes){
			System.out.println(c.getName().toString());
		}
		
		//随机排列collection中的值
		Collections.shuffle((List<Integer>)collection);
		System.out.println(collection);
		
		//只保留参数collection参数中的值------交集
		System.out.println(collection.retainAll(Arrays.asList(i)));
		System.out.println(collection);
		
		//List重载了addAll()方法，Collection中只有一个addAll
		List<Integer> arrayList=(ArrayList<Integer>) collection;
		//arrayList重载的addAll方法
		arrayList.addAll(2, Arrays.asList(10,11,12));
		System.out.println(arrayList);
		
		Integer[] i2={1,1,1,1,1,1,1,1,1,1,1,1,1};
		Object[] objects= arrayList.toArray(i2);
		System.out.println(Arrays.asList(objects));
		//////////////////////////java8-lambda表达式
		Arrays.asList(objects).stream().forEach(s -> System.out.println(s));//java8 
		
		
	}
}
