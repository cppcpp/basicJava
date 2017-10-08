package Collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListIteratorTest {
	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(1,2,3,4,5);
		ListIterator<Integer> listIterator= list.listIterator();
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}
		
		//使用相同的 种子创建Random，调用相同方法会产生相同的数字序列
		Random random=new  Random(23);
		Random random2=new Random(23);
		System.out.println(random.nextInt()+" "+random2.nextInt());
	}
}
