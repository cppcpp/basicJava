package sort;

/*
 * 直接插入排序
 * 如果有一个有序序列【1,2,5】将4插入时，将插入到2后面
 * 直接插入排序：如果有i个元素，就进行i-1次插入，先把第一个元素作为有序集，插入第二个数，再把第三个数插入...
 * 时间复杂度：O(n~2)
 * 
 * */
public class StraightInsertionSort extends Sort {

	public StraightInsertionSort(int[] array) {
		super(array);
	}

	@Override
	public int[] sortAlgorithm(int[] array) {
		return insertionSort2();
	}

	public int[] insertionSort1() {
		if(array==null||array.length<2){
			return array;
		}
		
		// 从第二个数开始往里面插入
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				// 将array[i]插入前面的j个数中
				if (array[i] <= array[j]) {
					int temp = array[i];
					for (int k = i - 1; k >= j; k--) {
						array[k + 1] = array[k];
					}
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	public int[] insertionSort2(){
		if(array==null||array.length<2){
			return array;
		}
		
		for(int i=1;i<array.length;i++){
			for(int j=0;j<i;j++){
				//如果array[i]比array[j]小的话，就替换两个数的位置
				if(array[i]<array[j]){
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		return array;
	}

}
