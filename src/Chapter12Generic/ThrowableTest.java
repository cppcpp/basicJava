package Chapter12Generic;

import java.io.File;
import java.util.Scanner;


public class ThrowableTest {
	public static void main(String[] args) {
		new AbstractBlock(){
			public void body() throws Exception {
				Scanner in=new Scanner(new File("sss"));
				while(in.hasNext()){
					System.out.println(in.next());
				}
			}
		}.toThread().run();
	}
}


