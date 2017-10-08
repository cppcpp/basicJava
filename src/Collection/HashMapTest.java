package Collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest extends HashMap<String, String>{
	public static void main(String[] args) {
		 int n = 3 - 1;
	      n |= n >>> 1;
	      System.out.println(n);
	      
	      HashMap<String,String> map=new HashMap<>();
	      map.put("1", "1");
	      map.put("3", "3");
	      map.put("2", "2");
	      map.put("4", "4");
	      map.put("5", "4");
	      for(Map.Entry<String,String> entry: map.entrySet()){
	    	  System.out.println(entry.getKey()+":"+entry.getValue());
	      }
	      for(String str:map.values()){
	    	  System.out.println(str);
	      }
	}
}	
