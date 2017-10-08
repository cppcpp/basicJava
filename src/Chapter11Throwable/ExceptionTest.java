package Chapter11Throwable;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ExceptionTest implements Closeable{
	
	public void test() throws FileNotFoundException{
		//String path= this.getClass().getClassLoader().getResource("/").getPath();
		//System.out.println("��·��::"+path);
		
		//����Դ��try��� ����try-with-resource   �����Զ�������Դ���á���������
		try(Scanner sc=new Scanner(new FileInputStream("readme.txt"))){
			while(sc.hasNext()){
				System.out.println(sc.next());
			}
		}
	}
	
	//��ջ����
	public int factorial(int a){
		System.out.println("factorial::"+a);
		Throwable t=new Throwable();
		StackTraceElement[] frans=t.getStackTrace();
		for(StackTraceElement f:frans){
			System.out.println(f);
		}
		int s;
		if(a<=1) s=a;
		else s=a*factorial(a-1);
		System.out.println("return ::"+s);
		return s;
	}
	
	//��catch���ٴ��׳��쳣���쳣��
	public void ExceptionAgain() throws Throwable{
		try {
			Scanner sc=new Scanner(new FileInputStream("/readme.txt"));
		} catch (FileNotFoundException e) {
			Throwable t=new Throwable("Scanner error");
			t.initCause(t);
			throw t;
			
		}
	}
	public static void main(String[] args)   {
		ExceptionTest test= new ExceptionTest();
		try {
				test.test();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//System.out.println(test.factorial(3));
		/*try {
			test.ExceptionAgain();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			//�ڴ˴������쳣��Դ
			//�쳣ʹ�û�������ֻ���쳣�����ʹ���쳣
			e.getCause();
			System.out.println("�쳣��Դ����"+e.getCause());
		}*/
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("���ùر���Դ�ķ���");
	}

}
