package sort;

import java.util.Arrays;
import java.util.function.IntPredicate;

/*
 * 快速排序：
 * 选择一个基点，左边都比他小，右边都比他大
 * 对基点的左边、右边重复这样操作
 * 
 * */
public class QuickSort extends Sort {

	public QuickSort(int[] array) {
		super(array);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] sortAlgorithm(int[] array) {
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));;
		return array;
	}

	public void quickSort(int[] array, int low, int high) {
		if(low>=high){
			return ;
		}
		// 用低位作为基准
		int index = array[low];
		int i=low;
		int j=high;

		//交替遍历
		while (i<j) {
			//必须加上:::出现i=j=0的情况出现下标为-1的异常
			while(array[j]>=index&&i<j){
				j--;
			}
			
			if (array[j] < index) {
				array[i]=array[j];
			}

			//必须加上:::出现i=j=length-1时，++的话出现数组越界异常
			while(array[i]<=index&&i<j)
				i++;
			if(array[i]>index){
				array[j]=array[i];
			}
		}
		array[i]=index;
		quickSort(array,low,i-1);
		quickSort(array, i+1, high);
	}

}
