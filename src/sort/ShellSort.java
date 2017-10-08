package sort;

/*
 * shell排序：
 * 1.选择一个增量序列d，每次按照增量序列选择出d组数据进行插入排序（首次增量序列为array.length）
 * 2.增量序列 每次/2，直到增量序列变为1
 * 
 * */
public class ShellSort extends Sort{

	public ShellSort(int[] array) {
		super(array);
	}

	@Override
	public int[] sortAlgorithm(int[] array) {
		shellSort();
		return array;
	}
	
	public void shellSort(){
		int length=array.length;
		//希尔排序的初始增量序列为length-1
		int d=array.length-1;
		
		while(d>=1){
			System.out.println("-----------------------");
			//增量序列为d，如果数据充足，共需要形成d组数据，否则退出
			//问题：：：：会有很多空循环
			for(int i=0;i<d;i++){
				//一组中数据下标差d，将这一组数据进行排序
				for(int j=i;j<length;j+=d){
					if((j+d)>length-1)
						break;
					
					if(array[j]>array[j+d]){
						System.out.println("交换："+array[j]+"和"+array[j+d]);
						//交换第j和第j+d个数
						int temp=array[j];
						array[j]=array[j+d];
						array[j+d]=temp;
						//new SwapUtil(array[j],array[j+d]);
					}
				}
			}
			d=d/2;
		}
		
		
	}

}
