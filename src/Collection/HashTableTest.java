package Collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class HashTableTest {
	public static void main(String[] args) {
		Hashtable<String,String> hashTable=new  Hashtable<String,String>();
		hashTable.put("1", "1");
		hashTable.put("3", "3");
		hashTable.put("2", "2");
		hashTable.put("4", "4");
		
		//是倒序的，因为源码中判断就是--来判断数组中是否有值的
		Enumeration enumeration=hashTable.elements();
		while(enumeration.hasMoreElements()){
			System.out.println(enumeration.nextElement());
		}
		
		Iterator<String> iterator=hashTable.keySet().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
}
