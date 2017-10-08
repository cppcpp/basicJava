package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * SubList是ArrayList的一个子类
 * */
public class SubListTest {
	public static void main(String[] args) {
		String[] strings={"12","34","56","78"};
		ArrayList<String> arrayList=new ArrayList<>();
		arrayList.addAll(Arrays.asList(strings));
		
		
		//前闭后开
		List<String> subList=arrayList.subList(0, 2);
		subList.add("4545");
		System.out.println(subList);
		System.out.println(arrayList);
		
		//修改原来的ArrayLIst的个数
		arrayList.remove(0);
		
		//java.util.ConcurrentModificationException因为执行subList的时候保存了list的modcount
		//System.out.println(subList);
		
		
	}
}
