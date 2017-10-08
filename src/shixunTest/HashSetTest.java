package shixunTest;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set set=new HashSet();
		set.add("123");
		set.add("123");
		set.add("23");
		
		System.out.println(set.size());
	}
}
