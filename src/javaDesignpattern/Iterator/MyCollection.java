package javaDesignpattern.Iterator;


public class MyCollection implements Collection{
	String[] str={"赵","钱","孙","李"};
	@Override
	public Iterator iterator() {
		return new MyIterator(this);
	}

	@Override
	public Object get(int index) {
		
		return str[index];
	}

	@Override
	public int size() {
		return str.length;
	}

}
