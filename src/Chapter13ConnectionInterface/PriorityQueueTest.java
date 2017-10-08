package Chapter13ConnectionInterface;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		//优先级队列---保存实现了comparable接口，，或比较器的类
		PriorityQueue<GregorianCalendar> pq=new PriorityQueue<>();
		pq.add(new GregorianCalendar(1902, 2, 30));
		pq.add(new  GregorianCalendar(2013,Calendar.DECEMBER, 2));
		pq.add(new GregorianCalendar(2012, 3, 3));
		
		System.out.println("for循环");
		for(GregorianCalendar data:pq){
			System.out.println(data.get(Calendar.YEAR));
		}
		
		System.out.println("Iterator：");
		Iterator<GregorianCalendar> it=pq.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().get(Calendar.YEAR));
			
		}		
		//从运行结果看，优先级队列总是删除最小的那个
		System.out.print("删除：：：");
		while(!pq.isEmpty()){
			System.out.println(pq.remove().get(Calendar.YEAR));
		}
		
	}
}
