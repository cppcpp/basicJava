package algorithmAndExercise;

import java.util.Arrays;

public class QuickSort {

	public static void sort(int[] ints,int from,int to){
		if(ints.length<2)
			return ;
		
		//默认选择首位做比较的基准
		int index=ints[from];
		int i=from;
		int j=to;
		
		//跳出快排循环的条件
		if(from>=to)
			return;
		while(i<j){
			//从后往前进行比较,如果值大于基准值，j标志位向后移动
			while(ints[j]>=index&&j>i){
				j--;
			}
			//此时，ints[i]的位置上其实就是index值，将index位置上的值变成index[j]
			if(ints[j]<index)
				ints[i]=ints[j];
			
			//从前往后搜索
			while(ints[i]<=index&&i<j)
				i++;
			//如果i指针上的值大于index，说明要将ints【i】的值向后移动，替换刚刚ints【j】上面的值
			if(ints[i]>index)
				ints[j]=ints[i];
		}
		//一轮比较后，将基准的前后的队列分别进行比较
		ints[i]=index;
		//这边注意不能是i--，
		sort(ints, from, i-1);
		sort(ints, i+1, to);
	}
	public static void main(String[] args) {
		int[] ints={2,5,3,7,12,56};
		sort(ints, 0, ints.length-1);
		System.out.println(Arrays.toString(ints));
	}
}
