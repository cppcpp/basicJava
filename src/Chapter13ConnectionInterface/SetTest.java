package Chapter13ConnectionInterface;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		//¼¯----------É¢ÁÐÂë
		/*Set<String> words=new HashSet();
		long totalTime=0;
		
		System.out.print("input£º");
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String word=in.next();
			System.out.println(word);
			long callTime=System.currentTimeMillis();
			words.add(word);
			callTime=System.currentTimeMillis()-callTime;
			totalTime+=callTime;
			System.out.println(callTime+"tootalTime:"+totalTime);
		}
		
		Iterator<String> iter=words.iterator();
		for(int i=0;i<=20&&iter.hasNext();i++)
			System.out.println(iter.next());
			System.out.println("...");
			System.out.println(words.size()+"distinctwords."+totalTime+"milliseconds.");
	*/
		
		Set<String> set=new HashSet<>();
		set.add("345");
		set.add("123");
		set.add("dfs");
		set.add("234");
		set.add("123");
		set.add("efewf");
		set.add("fhsihc");
		Iterator it=set.iterator();
		while(it.hasNext()){
		}
	}
	
	
	
	

}
