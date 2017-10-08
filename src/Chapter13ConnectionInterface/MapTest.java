package Chapter13ConnectionInterface;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		//Map的实现类有HashMap，和TreeMap，HashMap效率较高，如果不需要按顺序访问，则用HashMap
		//桶大小----填装因子
		Map<Integer,String> maps=new HashMap<>(3, (float) 0.75);
		maps.put(1, "tom");
		maps.put(2, "jack");
		maps.put(3, "alice");
		
		System.out.println(maps);
		//Iterator所有条目
		for(Map.Entry<Integer,String> entry:maps.entrySet()){
			Integer key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+":"+value);
		}
		
		
		//LinkedHashMap---链表映射表
		//实现“最近最少使用”原则-----
		Map<String,String> cache=new LinkedHashMap<String,String>(128, 0.75F, true){
			
			//重写此方法---每当方法返回true时，就添加一个新条目，从而到时删除eldest条目
			protected boolean removeEldestEntry(Map.Entry<String, String> eldest){
				return size()>100;
			}
		};
		
		//同步视图
		Map<String,String> synMap=Collections.synchronizedMap(new HashMap<String,String>());
		
		//插入时检查类型
		Map<String,String> checkedMap= Collections.checkedMap(new HashMap<>(), String.class,String.class);
		
		
	}
}
