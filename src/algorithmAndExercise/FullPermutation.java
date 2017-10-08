package algorithmAndExercise;

import java.util.Arrays;

/*
 * 全排列
 * */
public class FullPermutation {
	public static void fullPermutation(int[] ints,int from,int to){
		if(ints.length<2)
			return;
		if(from==to){
			System.out.println(Arrays.toString(ints));
			return;
		}else{
			for(int i=from;i<to;i++){
				//依次把第一，第二，第三。。。和第一位交换，所以进行排序的总是n-1个数
				swap(ints, from,i);
				fullPermutation(ints, from+1, to);
				//排序后，把位置换回来，以进行下一个数的排序
				swap(ints, i, from);
			}
		}
	}
	public static void swap(int[] ints,int a,int b){
		int temp=ints[a];
		ints[a]=ints[b];
		ints[b]=temp;
	}
	
	public static void main(String[] args) {
		int[] ints={1,2,3,4};
		FullPermutation.fullPermutation(ints,0,ints.length);
	}
}
