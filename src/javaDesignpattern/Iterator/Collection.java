package javaDesignpattern.Iterator;


public interface Collection {
	public Iterator iterator();
	//得到一个元素
	public Object get(int index);
	//集合的大小
	public int size();
}
