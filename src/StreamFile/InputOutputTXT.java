package StreamFile;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutputTXT implements Closeable{
	
	/*
	 * 1.����ı����ļ�
	 * 2.���ı�
	 * 
	 * */
	public static void main(String[] args) {
		//try-with-catch--�﷨��
		try( Scanner in=new Scanner(new FileInputStream("src\\readme.txt"));
				PrintWriter out= new PrintWriter("src\\readme.txt")){
			//PrintWriter out=new PrintWriter(new FileWriter("readme.txt"),true);
			//������д���ļ�д��true�����Զ�ˢ��
			//��ӡ��д����
			out.println("name");
			out.print("password");
			out.println(100);
			out.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�ر�����/�����");
	}

}
