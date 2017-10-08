package shixunTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

//ArrayList非线程安全
public class ArrayListTest extends Thread{
	@SuppressWarnings("rawtypes")
	private static ArrayList arrayList;
	public void run() {
		for(int i=0;i<100;i++){
				arrayList.add(i+"");
		}
	}
	public static void main(String[] args) {
		arrayList=new ArrayList();
		Thread thread1=new ArrayListTest();
		Thread thread2=new ArrayListTest();
		Thread thread3=new ArrayListTest();
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("size:"+ArrayListTest.arrayList.size());
		
	}
}
