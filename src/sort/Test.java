package sort;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] array={1,5,4,8,10,9,9};
		//实例化有排序算法的对象，在父类（抽象类）的构造方法中调用sort排序，执行后，array即排序完成
		new ShellSort(array); 
		System.out.println(Arrays.toString(array));
	}
}
