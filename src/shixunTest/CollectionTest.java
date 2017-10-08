package shixunTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionTest {
	
	public static void addListElements(List list){
		for(int i=0;i<10000;i++){
			list.add(i+"");
		}
	}
	public static void addLinkedListElements(LinkedList list){
		
	}
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		CollectionTest.addListElements(list);
		Iterator iterator=list.iterator();
		
	}
	
}
