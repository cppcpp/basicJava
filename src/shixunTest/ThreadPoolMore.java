package shixunTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.Vector;

public class ThreadPoolMore {
	static int num;
	public void init(){
		//读取属性文件
		InputStream in= this.getClass().getResourceAsStream("config.properties");
		Properties p=new Properties();
		
		try {
			p.load(in);
			int num=Integer.parseInt(p.getProperty("num"));
			ThreadPoolMore.num=num;
			System.out.println("当前模拟线程个数为："+num);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ThreadPoolMore test=new ThreadPoolMore();
		test.init();
		//初始化num大小的线程池
		ThreadPool threadPoool=new ThreadPool(ThreadPoolMore.num);
		//模拟执行任务
		while(true){
			System.out.println("请输入任务 名称");
			Scanner scanner=new Scanner(System.in);
			String taskName=scanner.next();
			threadPoool.executeTask(taskName);
			
		}
	}
}

class ThreadPool{
	private int maxpoolsize;
	private Vector<WorkThread> vThreads=new Vector<WorkThread>();
	public static ArrayList<String> taskLists=new ArrayList<String>();

	//新建maxpoolsize个线程
	public ThreadPool(int maxpoolsize){
		this.maxpoolsize=maxpoolsize;
		for(int i=0;i<maxpoolsize;i++){
			WorkThread workThread=new WorkThread();
			workThread.start();
			vThreads.add(workThread);
		}
	}
	
	//执行任务
	public void executeTask(String taskName){
		Boolean couldExecute = false;
		
		//如果任务队列大小<线程池大小,可以执行任务
		System.out.println("任务队列 大小："+taskLists.size()+"   "+"线程池大小："+vThreads.size());
		
		synchronized (couldExecute) {
				if(taskLists.size()>=vThreads.size()){
					System.out.println("线程池已满，请等待。。。");
					try {
						Thread.sleep(10*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
			//线程池循环查看线程中的空闲线程，如果有空闲线程，将任务分配给它执行
			for(int i=0;i<vThreads.capacity();i++){
				WorkThread workThread= vThreads.get(i);
				//如果当前子线程为空闲线程,将标志位设为true，表示当前前程为工作线程
				//在将任务放入任务链表中
				if(!workThread.isFlag()){
					taskLists.add(taskName);
					workThread.setTaskName(taskName);
					workThread.setFlag(true);
					break;
				}
			}
		}
	
}

class WorkThread extends Thread{
	private boolean flag;
	private String taskName;
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
		if(flag){
			//解锁当前线程
			synchronized(this){
				//优先级--------------------------
				this.notify();
			}
		}
	}

	
	public void run() {
		//为了不让线程死亡，循环执行
		while(true){
			if(flag){
				System.out.println(Thread.currentThread().getName()+"线程执行当前任务："+this.taskName);
				
				try {
					//模拟执行30秒
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(this.taskName+"执行完毕");
				//任务执行完毕，将其从任务队列中移除
				ThreadPool.taskLists.remove(taskName);
				//完成后，将flag对象设置成true
				this.setFlag(false);
				
				
			}else{//flag为false，表示当前线程为空闲线程
				try {
					System.out.println(Thread.currentThread().getName()+"为非工作线程，正在等待调用");
					synchronized (this) {
						this.wait();
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
}