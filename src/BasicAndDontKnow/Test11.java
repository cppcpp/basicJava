package BasicAndDontKnow;

import java.util.ArrayList;
import java.util.List;

public class Test11 {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<50;i++){
			list.add(i+1);
		}
		
		int count=1;
		int size=50;
		while(list.size()>1){
			
			int index=(count-1)%size;
			if(list.indexOf(index)%3==0){
				list.remove(index);
				System.out.print(list.indexOf(index)+"  ");
			}
			count++;
			
		}
		
		System.out.println(list.toString());
		
	}
}
