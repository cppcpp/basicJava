package Chapter13ConnectionInterface;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		//���ȼ�����---����ʵ����comparable�ӿڣ�����Ƚ�������
		PriorityQueue<GregorianCalendar> pq=new PriorityQueue<>();
		pq.add(new GregorianCalendar(1902, 2, 30));
		pq.add(new  GregorianCalendar(2013,Calendar.DECEMBER, 2));
		pq.add(new GregorianCalendar(2012, 3, 3));
		
		System.out.println("forѭ��");
		for(GregorianCalendar data:pq){
			System.out.println(data.get(Calendar.YEAR));
		}
		
		System.out.println("Iterator��");
		Iterator<GregorianCalendar> it=pq.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().get(Calendar.YEAR));
			
		}		
		//�����н���������ȼ���������ɾ����С���Ǹ�
		System.out.print("ɾ��������");
		while(!pq.isEmpty()){
			System.out.println(pq.remove().get(Calendar.YEAR));
		}
		
	}
}
