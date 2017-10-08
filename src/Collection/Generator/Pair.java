package Collection.Generator;

/*
 * 设置map键、值对的类
 * 设置为final，只能赋值一次
 * 
 * 并不需要担心public带来的非安全性，因为你不能将其他值赋值给final声明的变量
 * 
 *
 * */
public class Pair <K,V>{
	public final K key;
	public final V value;
	
	public Pair(K k,V v){
		this.key=k;
		this.value=v;
	}
}
