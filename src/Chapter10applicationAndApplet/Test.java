package Chapter10applicationAndApplet;

public class Test {
	static boolean foo(char flag){
		System.out.println(flag);
		return true;
	}
	public static void main(String[] args) {
		int i=0;
		
		//forѭ����һ������ֻ��ʼ��һ��
		for(foo('A');foo('B')&&i<2;foo('c')){
			foo('d');
			i++;
		}
	}
	

}
