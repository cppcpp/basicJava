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
		li.add("在tom后面添加");
		li.next();
		//set方法取代next或previous
		li.set("替代jack");
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
		System.out.println("将b中元素添加至a中："+a);
		
		bIter=b.iterator();
		System.out.println("b:"+b);
		while(bIter.hasNext()){
			bIter.next();
			if(bIter.hasNext()){
				bIter.next();
				bIter.remove();
			}
		}
		
		System.out.println("移除b中的第二个元素："+b);
		
		a.removeAll(b);
		System.out.println("a移除b中所有元素:"+a);
		
		
		String[] str=new String[3];
		str[0]="123";
		str[1]="234";
		str[2]="345";
		//返回的是视图对象-----不能对这个数组的大小有任何的修改，，否则报 java.lang.UnsupportedOperationException错
		System.out.println("---------q轻量级集包装器-------------");
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
