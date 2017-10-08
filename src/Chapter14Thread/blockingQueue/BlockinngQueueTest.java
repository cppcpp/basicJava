package Chapter14Thread.blockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * ���������п���һ���̡߳�����һ��Ŀ¼�µ�������Ŀ¼��������ӡ�������ƶ��ؼ��ֵ���
 * 
 * */
public class BlockinngQueueTest {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("����Ŀ¼---");
		String dictionary=in.nextLine();
		System.out.println("������Ҫ���ҵĴʣ�--");
		String keyword=in.nextLine();
		final int FILE_QUEUE_SIZE=10;
		final int SEARCH_THREADS=100;
		
		//��������
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
	
	//���캯��
	public FileEnumerationTask(BlockingQueue<File> queue,File startingDir){
		this.queue=queue;
		this.startingDir=startingDir;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			//���÷���ʱ�����쳣
			enumerate(startingDir);
			//----------������û�������򽫿��ļ�����
			queue.put(DUMMY);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void enumerate(File dictionary) throws InterruptedException{
		//�г���ǰĿ¼�µ������ļ�
		File[] files= dictionary.listFiles();	
		for(File file:files){
			
			//���Ŀ¼�µ��ļ�����Ŀ¼����������øĺ���
			if(file.isDirectory()){
				enumerate(file);
			}else{
				//put��������queueΪ����������
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
			
			//��û�����������ļ�ʱ����һֱ����
			boolean done=false;
			while(!done){
				//take�������������Ϊ�գ�������
				File file=queue.take();
				//���fileΪ���ļ��Ļ�
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
	
	//������ǰ�ļ��Ƿ�����ؼ���
	public void search(File file) throws FileNotFoundException{
		try(Scanner in=new Scanner(file)){
			int lineNumber=0;
			String line=in.nextLine();
			if(line.contains(keyword)){
				System.out.printf("Ŀ¼----%s%n��%d�� %n%s%n",file.getPath(),lineNumber,line);
			}
		}
	}
}