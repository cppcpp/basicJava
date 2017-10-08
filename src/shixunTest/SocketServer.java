package shixunTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class SocketServer {
	public void startServer(){
		System.out.println("------------------------服务器启动服务");
		
		
		//serverSocket
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(8845);
			
			while(true){
				
				//收到客户端消息之前，处于阻塞状态
				Socket socket= serverSocket.accept();
				
				new Thread(new ServiceThread(socket)).start();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		SocketServer server=new SocketServer();
		server.startServer();
	}
}


class ServiceThread implements Runnable{
	private Socket socket;
	
	public ServiceThread(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		
		System.out.println("当前线程："+Thread.currentThread().getName());
		System.out.println("产生的socket:"+socket);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("服务器收到的信息："+reader.readLine());
			
			PrintWriter writer=new PrintWriter(socket.getOutputStream());
			System.out.println("服务器-------------------------");
			System.out.println("输入服务器想发送给客户端的消息：");
			Scanner scanner=new Scanner(System.in);
			String serverMsg=scanner.nextLine();
			writer.println(serverMsg);
			writer.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
