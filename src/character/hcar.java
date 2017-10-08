package character;

import java.io.UnsupportedEncodingException;

public class hcar {
	public static void main(String[] args){
		String a="Ëü";
		byte[] by=a.getBytes();
		byte[] byutf;
		try {
			byutf = a.getBytes("utf-8");
			for(byte b:by){
				System.out.print(b);
			}
			System.out.println();
			for(byte b2:byutf){
				System.out.print(b2);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();	
		try {
			String b=new String(a.getBytes("gbk"),"gbk");
			System.out.println(b);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
