package BasicAndDontKnow;

public class HashCodeTest {	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String b="1";
		System.out.println(+b.hashCode());
		System.out.println("myhashCode:");
		System.out.println(myhashCode(b.toCharArray()));
		
		int i=0;
		char c='陈';
		int f=0+c;
		System.out.println("f:"+c);
	}

	public static int myhashCode(char[] value){
		int h=0;
        if (h == 0 && value.length > 0) {
            char val[] = value;
            for(char c:val){
            	System.out.println(c);
            }

            for (int i = 0; i < value.length; i++) {
            	System.out.println("h:"+h);
            	System.out.println("val[i]："+val[i]);
            	System.out.println("31 * h + val[i]:"+31 * h + val[i]);
                h = 31 * h + val[i];
                System.out.println("hhhhhhh"+h);
            }
        }
        return h;
		
	}
}
