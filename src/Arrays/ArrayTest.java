package Arrays;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;


public class ArrayTest {
	public static void main(String[] args) {
		String[] strings = { "123", "234", "345" };
		Integer aInteger = 1;
		String string = "12";
		aInteger.getClass().getClassLoader();

		System.out.println("Integer 的内部类");
		Class[] classes = aInteger.getClass().getDeclaredClasses();
		for (Class class1 : classes) {
			System.out.println(class1.getName().toString());
		}
		System.out.println();
		Class[] classes2 = aInteger.getClass().getClasses();
		for (Class class1 : classes2) {
			System.out.println(class1.getName().toString());
		}

		// getComponentType返回的是数组的组件类型，如果不是数组，返回null
		System.out.println("ComponentType:" + strings.getClass().getComponentType());
		// newInstance创建一个指定实例，指定长度的新数组
		Object object = Array.newInstance(strings.getClass().getComponentType(), 5);
		String[] strings2 = (String[]) object;
		System.out.println(Arrays.toString(strings2));

		URL url1 = ArrayTest.class.getResource("/");
		URL url2 = ArrayTest.class.getClassLoader().getResource("/");
		System.out.println(url1.toString());
		System.out.println(url2);
		
		String string2="abcdefg";
		char[] chars={1,2,3};
		string2.getChars(0, 2, chars, 0);
		
		
		System.out.println("chars:"+Arrays.toString(chars));

	}
}
