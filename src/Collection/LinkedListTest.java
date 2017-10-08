package Collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class LinkedListTest {
	public static void main(String[] args) {
		/*LinkedList<Integer> linkedList=new LinkedList<>(Arrays.asList(1,2,3,4));
		//remove：removeFirst()
		Integer integer= linkedList.remove();
		System.out.println(integer);
		System.out.println(linkedList);*/
		
		
		Vector<Integer> vector=new Vector<>(10, 5);
		vector.addAll(Arrays.asList(1,2,3,4));
		System.out.println(vector.size());
		
		
	}
}
