package algorithmAndExercise;

import java.util.Scanner;
/*
 * 1:队列个数
 * 
 * 2：队列长度
 * 3：队列值
 * 4：队列长度
 * 5：队列值
 * 。。。。。。
 * 
 * 如果输入的三个数随意组合，满足array[i]*array[i+1]是4的倍数，返回true，否则，返回false
 * */
public class Test1_2 {
	public static boolean flag=false; 
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int count=scanner.nextInt();
		//System.out.println("队列个数："+count);
		
		for(int i=0;i<count;i++){
			int size=scanner.nextInt();
			//System.out.println("第"+i+"个队列长度"+size);
			int[] ints=new int[size];
			//设置temp让scanner可以跳出下面的循环
			int temp=0;
			while(scanner.hasNext()){
				temp++;
				int value=scanner.nextInt();
				ints[temp-1]=value;
				if(temp==size) break;
			}
			//System.out.println("the "+i+" arrays is"+Arrays.toString(ints));
			
			//对传入的int型数组全排列，找出满足要求的数组，返回true否则false
			fullPermutation(ints, 0, ints.length);
			System.out.println(flag);
		}
		scanner.close();
	}
	
	//全排列
	public static void fullPermutation(int[] ints,int from,int to){
		if(ints.length<2)
			return;
		if(from==to){
			//System.out.println(Arrays.toString(ints));
			//满足条件，输出
			for(int i=0;i<ints.length-1;i++){
				if((ints[i]*ints[i+1])%4!=0)
					return;
			}
			flag=true;
			
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
	
}
