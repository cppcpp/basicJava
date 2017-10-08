package BasicAndDontKnow;

public class StringTest {
	public static void main(String[] args) {
		String a="qq";
		String d="qq";
		String b=new String("qq");
		String c=new String("qq");
		
		
		if(a.equals(b)){
			System.out.println("a equals b");
		}
		if (a==b) {
			System.out.println("a==b");
		}
		if(b==c){
			System.out.println("b==c");
		}
		if(a==d){
			System.out.println("a==d");
		}
		
		//只有当字符串equals时候相等，才相等
		//调用intern方法：如果javaStringpool中已经存在这个String（equals方法相等），返回线程池中这个String值
		//不存在，把这个string增加到线程池中，并返回这个String的引用
		System.out.println("22".intern()=="92".intern());
	}
}
