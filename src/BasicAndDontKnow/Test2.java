package BasicAndDontKnow;

public class Test2 {
	public static Test2 test2=new Test2();
	public static Test2 test21=new Test2();
	{
		System.out.println("构造块");
	}
	/*static{
		System.out.println("静态块");
	}*/
	public static void main(String[] args) {
		new Test2();
	}
}
