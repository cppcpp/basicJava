package cloneTest;

import java.io.IOException;
import java.util.Date;
/*
 * clone()方法必须实现Clonable接口，否则会出现CloneNotSupportedException异常
 * 
 * */
public class CloneTest {
	public static void main(String[] args) {
		Wife wife=new Wife("张三",new Date());
		Husband husband=new Husband(wife, 30);
		
		/*浅克隆：只克隆了外层对象，对象中的对象并没有克隆*/
		Husband husband2=(Husband) husband.clone();
		husband2.setAge(40);
		husband2.getWife().setName("李四");
		System.out.println("husband1 age:"+husband.getAge()+"   husband2 age:"+husband2.getAge());
		System.out.println("husband1和huaband2是否是同一对象："+(husband==husband2));
		System.out.println("wife name:"+husband.getWife().getName()+"   wife2 name:"+husband2.getWife().getName());
		System.out.println("wife是否是同一个对象："+(husband.getWife()==husband2.getWife()));
		System.out.println();
		try {
			/*深克隆：实现序列化接口，将对象写入流中。
			 * */
			Husband husband3=(Husband) husband.deepClone();
			husband3.setAge(50);
			husband3.getWife().setName("李四");
			System.out.println("husband1 age:"+husband.getAge()+"   husband3 age:"+husband3.getAge());
			System.out.println("wife name:"+husband.getWife().getName()+"   wife3 name:"+husband3.getWife().getName());
			System.out.println("husband1和huaband3是否是同一对象："+(husband==husband3));
			System.out.println("wife是否是同一个对象："+(husband.getWife()==husband3.getWife()));
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
