package Chapter13ConnectionInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class algorithm {
	public static void main(String[] args) {
		Set<String> a=new HashSet<>();
		Set<String> b=new HashSet<>();
		a.add("12");
		b.add("12");
		a.add("23");
		a.add("34");
		Set<String> result=new HashSet<>(a);
		//返回即在a中也在b中出现的元素
		result.retainAll(b);
		
		
		//将set转换成数组，，没有创建任何新的对象
		//a.toArray(new String[a.size()]);
		//System.out.println(a);
		
		//排序
		
		//比较器
		Comparator<Integer> comparator=new Comparator<Integer>() {
			
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		
		
		List<Integer> lista=new ArrayList<>();
		lista.add(123);
		lista.add(23);
		lista.add(89);
		//按照比较器中的顺序
		//Collections.sort(lista, comparator);
		//比较器中逆序
		Collections.sort(lista,Collections.reverseOrder(comparator));
		System.out.println(lista);
		
		
	}
}
