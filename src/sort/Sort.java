package sort;
/*
 * 用模板模式写排序
 * */
public abstract class Sort {
	protected int[] array;
	public Sort(int[] array){
		this.array=array;
		//直接在构造器中调用排序方法，实例化这个类即可返回排序后的数组
		sort();
	}
	
	//抽象方法
	public abstract int[] sortAlgorithm(int[] array);
	
	//实现算法的步骤
	public void sort(){
		sortAlgorithm(this.array);
	}
}
