package Collection;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector<Integer> vector=new Vector<>(Arrays.asList(1,2,3,4));
		
		Enumeration<Integer> enumeration=vector.elements();
		while(enumeration.hasMoreElements()){
			System.out.println(enumeration.nextElement());
		}
		
		
	}
}
