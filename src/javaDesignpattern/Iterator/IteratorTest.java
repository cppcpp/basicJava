package javaDesignpattern.Iterator;
/*
 * 迭代器模式
 * 
 * 即集合的迭代器
 * 
 * */
public class IteratorTest {
	public static void main(String[] args) {
		Collection collection=new MyCollection();
		Iterator iterator=collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println(iterator.previous());
	}
}
