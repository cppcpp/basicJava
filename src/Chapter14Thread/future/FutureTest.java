package Chapter14Thread.future;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入文件名");
		String dictionary=in.nextLine();
		System.out.println("输入要查找的关键字：");
		String keyword=in.nextLine();
		
		MathCounter counter=new MathCounter(new File(dictionary), keyword);
		FutureTask<Integer> task=new FutureTask<>(counter);
		Thread t=new Thread(task);
		t.start();
		
		try {
			System.out.println(task.get()+"matching files");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

class MathCounter implements Callable<Integer>{
	private File dictionary;
	private String keyword;
	private int count;
	
	public MathCounter(File dic,String keyword){
		this.dictionary=dic;
		this.keyword=keyword;
	}
	
	
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		count=0;
		
		try{
			System.out.println("执行");
			File[] files=dictionary.listFiles();
			///////
			List<Future<Integer>> results=new ArrayList<>();
			
			for(File file:files){
				//如果是目录的话，递归
				if(file.isDirectory()){
					MathCounter counter=new MathCounter(file, keyword);
					//用FutureTask包装器把Callable转换成Future
					FutureTask<Integer> task=new FutureTask<>(counter);
					results.add(task);
					//用FutureTask包装器把Callable转换成Runnable
					Thread t=new Thread(task);
					t.start();
				}else{
					
					if(search(file)){
						count++;
					}
				}
				
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
			System.out.println("产生中断异常");
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
