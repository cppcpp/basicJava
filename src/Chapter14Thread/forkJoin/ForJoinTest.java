package Chapter14Thread.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForJoinTest {
	public static void main(String[] args) {
		final int SIZE=1000;
		boolean flag;
		double[] numbers=new double[SIZE];
		for(int i=0;i<SIZE;i++){
			numbers[i]=Math.random();
			
		}
		Counter counter=new Counter(numbers, 0, numbers.length, new Filter(){

			public boolean accept(double d) {
				// TODO Auto-generated method stub
				return d>0.8;
			}
			
		});
		
		ForkJoinPool pool=new ForkJoinPool();
		//执行
		pool.invoke(counter);
		//join（）返回结果
		System.out.println("一共有"+counter.join()+"满足条件");
	}
}

interface Filter{
	boolean accept(double d);
} 

//将会产生一个T类型的结果
class Counter extends RecursiveTask<Integer>{
	public static final int THRESHOLD=100;
	private double[] values;
	private int from;
	private int to;
	private Filter filter;
	
	public Counter(double[] values,int from ,int to,Filter filter){
		this.values=values;
		this.from=from;
		this.to=to;
		this.filter=filter;
	}

	
	@Override
	protected Integer compute() {
		if(to-from<THRESHOLD){
			int count=0;
			
			//如果在from和to之间的数满足filter.accept(i)，count++
			for(int i=from;i<to;i++){
				if(filter.accept(values[i])){
					count++;
				}
			}
			return count;
		}else{
			int mid=(from+to)/2;
			Counter first=new Counter(values,from,mid,filter);
			Counter second=new Counter(values,mid,to,filter);
			
			this.invokeAll(first,second);
			return first.join()+second.join();
		}
	}
	
}