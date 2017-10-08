package javaDesignpattern.Iterator;

public class MyIterator implements Iterator{
	private Collection collection;
	private static int position=-1;
	
	public MyIterator(Collection collection){
		this.collection=collection;
	}
	
	@Override
	public boolean hasNext() {
		int next=position+1;
		if(next<collection.size()){
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		if(position++<collection.size()){
			return collection.get(position);
		}
		return null;
	}

	@Override
	public Object previous() {
		if(position-->0){
			return collection.get(position);
		}
		return null;
	}

}
