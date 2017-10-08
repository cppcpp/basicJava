package sort;

/*
 * 简单选择排序：
 * 第一次从[0,n]中选择出最小的元素，和第一个交换，
 * 第二次从[1,n]中选最小的，和第二个交换
 * ...
 * */
public class SimpleSelectionSort extends Sort{

	public SimpleSelectionSort(int[] array) {
		super(array);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] sortAlgorithm(int[] array) {
		simpleSelectionSort(array);
		return array;
	}
	
	public void simpleSelectionSort(int[] array){
		int length=array.length;
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				//选择出[i,,length]中最小的数，和第i个数交换
				if(array[j]<array[i]){
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
	}

}
