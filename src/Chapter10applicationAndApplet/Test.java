package Chapter10applicationAndApplet;

public class Test {
	static boolean foo(char flag){
		System.out.println(flag);
		return true;
	}
	public static void main(String[] args) {
		int i=0;
		
		//for循环第一个条件只初始化一次
		for(foo('A');foo('B')&&i<2;foo('c')){
			foo('d');
			i++;
		}
	}
	

}
