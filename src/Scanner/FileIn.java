package Scanner;

import java.awt.geom.Area;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class FileIn {
	public static void main(String args[]) throws IOException{
//		//���ļ�
//		Scanner in=new Scanner(Paths.get("D:\\11111.docx"));
//		String a= in.nextLine();
//		System.out.println(a);
//		
//		//��ȡ�ļ�����·��
//		String dir=System.getProperty("D:\\11111.docx");
//		System.out.println(dir);
		
//		//д���ļ�����������ڣ����½��ļ�
//		PrintWriter out=new PrintWriter("D:\\33333.txt");
//		out.write("e44343");
//		out.append("343434");
//		out.flush();//ˢ�»���
		
		/*int[] a={1,2,3,4};
		System.out.println(Arrays.toString(a));
		//��������
		System.out.println(new int[]{1,2,3,4});	*/
		
		for(String a:args){
			System.out.println(a);
		}
	}
}
