package Chapter13ConnectionInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class algorithm {
	public static void main(String[] args) {
		Set<String> a=new HashSet<>();
		Set<String> b=new HashSet<>();
		a.add("12");
		b.add("12");
		a.add("23");
		a.add("34");
		Set<String> result=new HashSet<>(a);
		//���ؼ���a��Ҳ��b�г��ֵ�Ԫ��
		result.retainAll(b);
		
		
		//��setת�������飬��û�д����κ��µĶ���
		//a.toArray(new String[a.size()]);
		//System.out.println(a);
		
		//����
		
		//�Ƚ���
		Comparator<Integer> comparator=new Comparator<Integer>() {
			
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		
		
		List<Integer> lista=new ArrayList<>();
		lista.add(123);
		lista.add(23);
		lista.add(89);
		//���ձȽ����е�˳��
		//Collections.sort(lista, comparator);
		//�Ƚ���������
		Collections.sort(lista,Collections.reverseOrder(comparator));
		System.out.println(lista);
		
		
	}
}
