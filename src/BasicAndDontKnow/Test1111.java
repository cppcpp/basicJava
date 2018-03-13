package BasicAndDontKnow;

public class Test1111 {
	public static int a = 5;
	static {
		a = a * 3;
	}

	public static void main(String[] args) {
		System.out.println(a);
	}

	static {
		a = a / 3;
	}
}
