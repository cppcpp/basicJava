package shixunTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	public void clientInit(){
		System.out.println("----------------------初始化客户端");
		
		while(true){
			try {
				Socket socket=new Socket("127.0.0.1", 8845);
				
				//从键盘输入
				System.out.println("客户端----------------------");
				System.out.println("请输入传送给服务器的信息：");
				BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				
				String inputLine=reader.readLine();
				
				//写入输出流
				PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
				printWriter.println(inputLine);
				printWriter.flush();
				
				BufferedReader reader2=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("客户端接受服务器消息："+reader2.readLine());
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		SocketClient client=new SocketClient();
		client.clientInit();
	}
}
