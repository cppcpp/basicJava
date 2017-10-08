package gc;

import javax.print.attribute.standard.MediaName;

/*
 * java虚拟机栈和本地方法区发生OutOfMemoryError
 * 
 * 通过不断建立线程：每个线程的栈空间分配越大，越容易内存泄漏
 * 此时不妨把栈内存设置的大一点：-Xss2m
 * 
 * ****建立多线程导致程序内存溢出，解决办法之一：
 * 		减小最大堆，，和，，减小栈容量
 * 
 * 
 * */
public class JavaVMStackOOM{
	public void dontstop(){
		while(true){}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread=new Thread(new Runnable() {
				@Override
				public void run() {
					while(true){
						dontstop();
					}
				}
			});
			thread.start();
		}
	}
	public static void main(String[] args) {
		JavaVMStackOOM test=new JavaVMStackOOM();
		test.stackLeakByThread();
	}
	
}
