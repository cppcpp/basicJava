package Chapter14Thread.blockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * 用阻塞队列控制一组线程。搜索一个目录下的所有子目录，，，打印出包含制定关键字的行
 * 
 * */
public class BlockinngQueueTest {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("输入目录---");
		String dictionary=in.nextLine();
		System.out.println("输入想要查找的词：--");
		String keyword=in.nextLine();
		final int FILE_QUEUE_SIZE=10;
		final int SEARCH_THREADS=100;
		
		//阻塞队列
		BlockingQueue<File> queue=new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
		
		FileEnumerationTask enumerator=new FileEnumerationTask(queue, new File(dictionary));
		new Thread(enumerator).start();
		for(int i=0;i<=SEARCH_THREADS;i++){
			new Thread(new SearchTask(queue,keyword)).start();
		}
		
	}
}

class FileEnumerationTask implements Runnable{
	public static File DUMMY=new File("");
	private BlockingQueue<File> queue;
	private File startingDir;
	
	//构造函数
	public FileEnumerationTask(BlockingQueue<File> queue,File startingDir){
		this.queue=queue;
		this.startingDir=startingDir;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			//调用方法时捕获异常
			enumerate(startingDir);
			//----------若队列没有满，则将空文件放入
			queue.put(DUMMY);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void enumerate(File dictionary) throws InterruptedException{
		//列出当前目录下的所有文件
		File[] files= dictionary.listFiles();	
		for(File file:files){
			
			//如果目录下的文件还是目录，则继续调用改函数
			if(file.isDirectory()){
				enumerate(file);
			}else{
				//put方法，若queue为满，则阻塞
				queue.put(file);
			}
			
		}
	}
	
}

class SearchTask implements Runnable{
	private BlockingQueue<File> queue;
	private String keyword;
	
	public SearchTask(BlockingQueue<File> queue,String keyword){
		this.queue=queue;
		this.keyword=keyword;
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			//当没有搜索到空文件时，就一直搜索
			boolean done=false;
			while(!done){
				//take方法：如果队列为空，则阻塞
				File file=queue.take();
				//如果file为空文件的话
				if(file==FileEnumerationTask.DUMMY){
					queue.put(file);
					done=true;
				}else{
					search(file);
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//搜索当前文件是否包含关键字
	public void search(File file) throws FileNotFoundException{
		try(Scanner in=new Scanner(file)){
			int lineNumber=0;
			String line=in.nextLine();
			if(line.contains(keyword)){
				System.out.printf("目录----%s%n第%d行 %n%s%n",file.getPath(),lineNumber,line);
			}
		}
	}
}