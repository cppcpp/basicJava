package Chapter14Thread.thread;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("输入目录---");
		String dictionary=in.nextLine();
		System.out.println("输入想要查找的词：--");
		String keyword=in.nextLine();
		
		//返回实现ExecutorService接口的ThreadPoolExecutor对象
		ExecutorService pool=Executors.newCachedThreadPool();
		MathCounter counter=new MathCounter(new File(dictionary), keyword, pool);
		Future<Integer> future= pool.submit(counter);
		
		
		
		try {
			System.out.println("共有"+future.get()+"条数据符合");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//不再提交任务时，调用shutdown结束任务
		pool.shutdown();
		
		//最大线程数
		int largestPlloSize=((ThreadPoolExecutor)pool).getLargestPoolSize();
		System.out.println("最大线程数目："+largestPlloSize);
	}
}

class MathCounter implements Callable<Integer>{
	private File dictionary;
	private String keyword;
	private ExecutorService pool;
	private int count;
	
	public MathCounter(File dictionary,String keyword,ExecutorService pool){
		this.dictionary=dictionary;
		this.keyword=keyword;
		this.pool=pool;
	}
	
	
	
	@Override
	public Integer call() throws Exception {
		count=0;
		
		try{
			File[] files=dictionary.listFiles();
			List<Future<Integer>> results=new ArrayList<>();
			
			for(File file:files){
				if(file.isDirectory()){
					MathCounter counter=new MathCounter(file,keyword,pool);
					//线程池提交任务，得到Future对象，用来查询该任务的状态
					Future<Integer> result=pool.submit(counter);
					results.add(result);
				}else{
					if(search(file)){
						count++;
					}
				}
				
				//++count
				for(Future<Integer> result:results){
					
					try{
						count+=result.get();
						System.out.println("future里面结果::"+result.get());
						
					}catch(ExecutionException e){
						e.printStackTrace();
					}
				}
				
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return count;
	}
	
	//如果包含关键字，返回true
	public boolean search(File file){
		try{
			
			try(Scanner in=new Scanner(file)){
				boolean found=false;
				
				while(in.hasNextLine()&&!found){
					String line=in.nextLine();
					if(line.contains(keyword)){
						found=true;
					}
				}
				
				return found;
				
			} 
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			return false;

		}
		
		
	}
	

}