package TwoChapter1StreamFile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;

public class ReadByte {
	
	public static void main(String[] args) {
		/*
		 * Unicode���ɶ���ֽڹ���
		 * 
		 * java.io�������඼�Ƕ���       �����·����------>�û�����Ŀ¼
		 * ���ڷ�б����Java����ת���ַ������ȷ����Windows����е�·����ʹ��'\\'
		 * 
		 * */
		//�õ�Java���ļ��ָ��
		String separator=java.io.File.separator;
		
		//System.in:�Ӽ����϶�����Ϣ
		InputStreamReader inputR=new InputStreamReader(System.in);

		String path= System.getProperty("src/TwoChapter1StreamFile/readme.txt");
		System.out.println(path);////////////////???????????�õ�null
		
		try {
			//�����·��
			InputStream in=new FileInputStream("src\\readme.txt");
			//read()��������һ��Unicode��Ԫ�����ߵ��ļ�ĩβ����-1
			System.out.println("������"+in+"   ");
			/*while(in.read()!=-1){
				System.out.println(in.read());
			}*/
			//��BufferedReader���ı�����
			BufferedReader readerIn=new BufferedReader(new InputStreamReader(in, "gbk"));
			System.out.println("BufferedReader���ı������ݣ�");
			while(readerIn.readLine()!=null){
				System.out.println(readerIn.readLine());
			}
			//readerIn.close();
			//����-------��Scanner���ı�����
			System.out.println("scanner���ı����룺����");
			Scanner sin=new Scanner(in);
			System.out.println("sinhasnextline---��"+sin.hasNextLine());
			while(sin.hasNextLine()){
				System.out.println(sin.nextLine());
			}
			sin.close();
			/*
			 * java�ַ���
			 * 
			 * */
			//�ض�ʵ���еĿ����ַ���
			Map<String,Charset> charsets= Charset.availableCharsets();
			for(String name:charsets.keySet()){
				//System.out.println(name);
			}
			
			//����
			Charset c=Charset.forName("gbk");
			String name="������";
			ByteBuffer buffer=c.encode(name);
			byte[] bytes=buffer.array();
			System.out.println("��gbk�������ֽ����У�");
			for(byte b2:bytes){
			System.out.print(b2+"  ");	
			}
			System.out.println();
			//����
			//wrap�������ֽ�����ת��Ϊһ���ֽڻ�����
			ByteBuffer deBuffer=ByteBuffer.wrap(bytes);
			CharBuffer cbuffer=c.decode(deBuffer);
			System.out.println("������ֵ��"+cbuffer.toString());
			
			
			
			
			
			String password="���ǳ�����";
			//��UTF-8����������-----�ѵ���windowsϵͳ���ַ����йأ���������������������������������������
			Charset c2=Charset.forName("UTF-8");
			//����
			ByteBuffer buffer2 =c2.encode(password);
			//�õ��ֽ�����
			byte[] bytes2=buffer2.array();
			//������
			System.out.println("��utf-8������ֵ");
			for(byte b3:bytes2){
				System.out.print(b3+"  ");
			}
			System.out.println();
			//����---�ǵ�Ȼ����ͬ���ַ����������������--wrap���Խ��ֽ�����ת���ֽڻ���
			ByteBuffer buffer3= ByteBuffer.wrap(bytes2);
			CharBuffer charBuffer= c2.decode(buffer3);
			System.out.println(charBuffer.toString());
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("δ�ҵ����ļ�");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}
}
