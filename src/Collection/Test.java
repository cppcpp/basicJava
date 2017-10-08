package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		userful[] userfuls={
				new userful(),
				new moreUseful()
		};
		//((moreUseful)userfuls[1]).c();//运行时类型识别
		//((moreUseful)userfuls[0]).c();
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		//允许值为null
		map.put(1, 1);
		map.put(2,null);
		map.put(null, 3);
		Map<Integer,Integer> map1=new HashMap<Integer,Integer>();
		//允许值为null
		map1.put(1, 1);
		map1.put(2,null);
		map1.put(null, 3);
		Set<Entry<Integer,Integer>> set=map1.entrySet();
		for(Entry<Integer,Integer> entry:set){
			System.out.println(entry);
		}
		//比较里面的键值
		System.out.println("map equals map1:"+map.equals(map1));
		
	}
}
class userful{
	public void a(){}
	public void b(){}
}

class moreUseful extends userful{
	public void a(){}
	public void b(){}
	public void c(){}
}