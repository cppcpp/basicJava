package BasicAndDontKnow;


public class OverriteTest {
	public void a(Object a){
		System.out.println("Object a");
	}
	public void a(String a){
		System.out.println("String a");
	}
	public static void main(String[] args) {
		String aString="123";
		OverriteTest test=new OverriteTest();
		test.a(aString);
	}
}
