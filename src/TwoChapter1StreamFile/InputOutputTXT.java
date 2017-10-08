package TwoChapter1StreamFile;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutputTXT implements Closeable{
	
	/*
	 * 1.输出文本到文件
	 * 2.读文本
	 * 
	 * */
	public static void main(String[] args) {
		//try-with-catch--语法糖
		try( Scanner in=new Scanner(new FileInputStream("src\\readme.txt"));
				PrintWriter out= new PrintWriter("src\\readme.txt")){
			//PrintWriter out=new PrintWriter(new FileWriter("readme.txt"),true);
			//是上面写法的简写，true代表自动刷新
			//打印到写出器
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
		System.out.println("关闭输入/输出流");
	}

}
