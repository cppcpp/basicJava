package Chapter11Throwable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Scanner;

public class Debuggingtest {
	
	public static void main(String[] args){
		try {
			Scanner sc=new Scanner(new FileInputStream("/readme.txt"));
			//������ط���ö�ջ����
			//Thread.dumpStack();
		} catch (Throwable e) {
			//e.printStackTrace();
			
			//����ջ���ٲ����ַ�����
			ByteArrayOutputStream out=new ByteArrayOutputStream();
			PrintWriter writer=new PrintWriter(out);
			e.printStackTrace(writer);
			String description=writer.toString();
			System.out.println("description::==="+description);
			
			
			//����thread�ľ�̬������ĳЩ�ǲ����쳣�Ķ�ջ��Ϣ������ļ���
			Thread.setDefaultUncaughtExceptionHandler(
					new UncaughtExceptionHandler() {
						@Override
						public void uncaughtException(Thread t, Throwable e) {
							// TODO Auto-generated method stub
							//������Ϣ��log��־�ļ���
							
						}
					});
		}
	}
}
