package Chapter13ConnectionInterface;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest{
	public static void main(String[] args) {
		/*List<String> lists=new LinkedList<>();
		lists.add("tom");
		lists.add("jack");
		//Iterator it=lists.iterator();
		ListIterator<String> li=lists.listIterator();
		li.next();
		li.add("��tom�������");
		li.next();
		//set����ȡ��next��previous
		li.set("���jack");
		while(li.hasPrevious()){
			System.out.println(li.previous());
		}*/
		
		List<String> a=new LinkedList<>();
		a.add("Amy");
		a.add("Bole");
		a.add("carl");
		List<String> b=new LinkedList<>();
		b.add("dom");
		b.add("elam");
		b.add("fole");
		b.add("girl");
		
		ListIterator<String> aIter=a.listIterator();
		Iterator<String> bIter=b.iterator();
		
		while(bIter.hasNext()){
			if(aIter.hasNext()) aIter.next();
			aIter.add(bIter.next());
		}
		System.out.println("��b��Ԫ�������a�У�"+a);
		
		bIter=b.iterator();
		System.out.println("b:"+b);
		while(bIter.hasNext()){
			bIter.next();
			if(bIter.hasNext()){
				bIter.next();
				bIter.remove();
			}
		}
		
		System.out.println("�Ƴ�b�еĵڶ���Ԫ�أ�"+b);
		
		a.removeAll(b);
		System.out.println("a�Ƴ�b������Ԫ��:"+a);
		
		
		String[] str=new String[3];
		str[0]="123";
		str[1]="234";
		str[2]="345";
		//���ص�����ͼ����-----���ܶ��������Ĵ�С���κε��޸ģ������� java.lang.UnsupportedOperationException��
		System.out.println("---------q����������װ��-------------");
		List<String> list=Arrays.asList(str);
		List<String> list2=Arrays.asList("123","234","34");
		
		Iterator it=list.iterator();
		System.out.println(it.next());
		it.remove();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	
	
}
