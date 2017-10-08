package algorithmAndExercise;

import java.util.Arrays;

//希尔排序---选定一个增序，每次按照这个增序比较两个值，增序--，直到增序降为1
public class ShellSortTest {
	public static void shellSort(int[] ints){
		int length=ints.length;
		int d=length/2;
		while(d>0){
			for(int i=0;i<length;i++){
				if(i+d>length-1)
					break;
				if(ints[i]>ints[i+d]){
					int temp=ints[i];
					ints[i]=ints[i+d];
					ints[i+d]=temp;
				}
			}
			
			d--;
		}
		
		System.out.println(Arrays.toString(ints));
		
	}
	public static void main(String[] args) {
		int[] ints={45,32,75,123,3,5};
		shellSort(ints);
	}
}
