package Collection.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDataTest {
	public static void main(String[] args) {
		//将适配器适配进Collection中
		Set<String> set=new LinkedHashSet(new CollectionData<>(new Government(), 10));
		System.out.println(set);
		
	}
}
