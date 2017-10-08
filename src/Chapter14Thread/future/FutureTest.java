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
		System.out.println("�������ļ���");
		String dictionary=in.nextLine();
		System.out.println("����Ҫ���ҵĹؼ��֣�");
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
			System.out.println("ִ��");
			File[] files=dictionary.listFiles();
			///////
			List<Future<Integer>> results=new ArrayList<>();
			
			for(File file:files){
				//�����Ŀ¼�Ļ����ݹ�
				if(file.isDirectory()){
					MathCounter counter=new MathCounter(file, keyword);
					//��FutureTask��װ����Callableת����Future
					FutureTask<Integer> task=new FutureTask<>(counter);
					results.add(task);
					//��FutureTask��װ����Callableת����Runnable
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
						System.out.println("future������::"+result.get());
						
					}catch(ExecutionException e){
						e.printStackTrace();
					}
				}
				
			}
		}catch(InterruptedException e){
			System.out.println("�����ж��쳣");
		}
		
		return count;
	}
	
	//��������ؼ��֣�����true
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
