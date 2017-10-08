package Arrays;

import java.util.Arrays;

//Binary的底层实现
public class ArraysBinaryTest {
	public static void main(String[] args) {
		char[] chars={'1','2','3','4','5'};
		int a=getKey(chars,'5');
		System.out.println(a);
		//sort
		char[] chars2={'3','5','4','6','8'};
		Arrays.sort(chars2);
		System.out.println(Arrays.toString(chars2));
	}
	
	public static int getKey(char[] a,char key){
		int end=a.length-1;
		int begin=0;
		
		while(end>=begin){
			int mid=(begin+end)>>>1;
			char midValue=a[mid];
			
			if(key>midValue){
				begin=mid+1;
			}else if(key<midValue){
				end=mid-1;
			}else {
				return mid;//找到
			}
		}
		return -(begin+1);
				
	}
}
