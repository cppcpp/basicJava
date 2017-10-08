package Collection.Generator;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 产生Map的适配器类
 * 
 * */
public class MapData<K,V> extends LinkedHashMap<K, V>{
	
	//一个单独的Generator，里面存放Pair类
	public MapData(Generator<Pair<K, V>> generator,int quantity){
		for(int i=0;i<quantity;i++){
			Pair<K, V> pair= generator.next();
			put(pair.key, pair.value);
		}
	}
	
	//两个分离的Generator，分别代表key和value
	public MapData(Generator<K> keys,Generator<V> values,int quantity){
		for(int i=0;i<quantity;i++){
			K key=keys.next();
			V value=values.next();
			put(key, value);
		}
	}
	
	//一个Generator，一个单独的value
	public MapData(Generator<K> keys,V value,int quantity){
		for(int i=0;i<quantity;i++){
			K key=keys.next();
			put(key, value);
		}
	}
	
	//一些简便的实例化MapData方法
	public  static <K,V> MapData<K, V> map(Generator<Pair<K, V>> generator,int quantity){
		return new MapData<>(generator, quantity);
	}
	
	public static <K,V>MapData<K, V> map(Generator<K> keys,Generator<V> values,int quantity){
		return new MapData<>(keys,values, quantity);
	}
	
	public static <K,V>MapData<K, V> Map(Generator<K> keys,V value,int quantity){
		return new MapData<K, V>(keys, value, quantity);
	}
	
	
}
