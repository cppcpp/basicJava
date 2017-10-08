package Chapter5;

import java.lang.Enum;
import java.util.Scanner;
public class EnumTest {
	public enum Size{SMALL,MEDIUM,LARGE};
	//Size���͵ı���ֻ�ܴ洢�����������ʱ���е�ĳһ��ö��ֵ������null
	//�Ƚ�ʱֻ��Ҫ�á�==������Զ����Ҫ��equals
	Size s=Size.LARGE;
	
	public static void main(String[] args) {
		//1.����ö�����ͳ���
		Size.LARGE.toString();
		//2.��ss���ó�Size.small
		Size ss=Enum.valueOf(Size.class, "SMALL");
		//3.���ذ���ȫ��ö��ֵ������
		Size[] values=Size.values();
		
		
		
		
		Scanner in=new Scanner(System.in);
		System.out.println("please input a Size��(SMALL,MEDIUM,LARGE)��");
		String input=in.next().toUpperCase();
		Size2 s2=Enum.valueOf(Size2.class,input);
		System.out.println("size:"+s2);
		System.out.println("��������ǣ�"+s2.getAbb());
		if(s2==Size2.LARGE){
			System.out.println("���������LARGESize");
		}
	}
	enum Size2{
		SMALL("S"),MEDIUM("M"),LARGE("L");
		private String abb;
		
		private Size2(String abb){this.abb=abb;}
		public String getAbb(){return abb;}
		
	}
}
