package Collection.Generator;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 用MapData类填充LinkedHashMap
 * 然后通过构造器或者Collections.addAll()或者Map.putAll()就可以初始化Map和Collection、
 * */
public class MapDataTest {
	public static void main(String[] args) {
		Map<Integer, String> map= new LinkedHashMap<>();
		map.putAll(new MapData<>(new Letters(),20));
		System.out.println(map);
	}
}
