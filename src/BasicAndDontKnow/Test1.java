package BasicAndDontKnow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test1 extends Test{
	public static void main(String[] args) {
		Test1 test1=new Test1();
		test1.a("2");
		final int a=9;
		Map<Integer, Integer> map=new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		Iterator iterator=map.keySet().iterator();
		while(iterator.hasNext()){
			Integer integer=(Integer) iterator.next();
			System.out.println("键："+integer+"  值："+map.get(integer));
		}
		
		//动态数组
		List<String> arrayList=new ArrayList<>();
		arrayList.add("12");
		arrayList.add("23");
		Iterator<String> iterator2=arrayList.iterator();
		while(iterator2.hasNext()){
			System.out.println(iterator2.next());
		}
		for(Iterator iterator3=arrayList.iterator();iterator3.hasNext();){
			System.out.println(iterator3.next());
		}
		
	}	
}
