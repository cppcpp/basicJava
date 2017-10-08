package treeSet;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		SortedSet<Item> parts=new TreeSet<>();
		parts.add(new Item("aom",123));
		parts.add(new Item("cack",234));
		parts.add(new Item("boaster",456));
		//按照添加顺序输出--说明TreeSet是有序的
		System.out.println(parts);
		
		//比较器，一般用匿名函数给出---比较方法的持有器
		/*new TreeSet<>(Comparator<? super E> comparator)
			构造一个新的空 TreeSet，它根据指定比较器进行排序。
		*
		*/
		SortedSet<Item> sortByDescription=new TreeSet<>(
				new Comparator<Item>(){

					@Override
					public int compare(Item a, Item b) {
						String descA=a.getDescription();
						String descB=b.getDescription();
						
						return descA.compareTo(descB);
					}
					
				}
				);
		
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}
}
