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
		//�������˳�����--˵��TreeSet�������
		System.out.println(parts);
		
		//�Ƚ�����һ����������������---�ȽϷ����ĳ�����
		/*new TreeSet<>(Comparator<? super E> comparator)
			����һ���µĿ� TreeSet��������ָ���Ƚ�����������
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
