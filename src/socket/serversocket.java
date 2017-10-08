package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class serversocket {
	public static void main(String args[]){
		ServerSocket serversocket;
		try {
		serversocket = new ServerSocket(3434);
		Socket socket=serversocket.accept();
		
		
		InputStream input=socket.getInputStream();
		OutputStream output=socket.getOutputStream();
		Scanner sc=new Scanner(input);
		PrintWriter out=new PrintWriter(output);
		out.println("Please input:");
		boolean done=false;
		while(!done&&sc.hasNext()){
			if(sc.nextLine().equals("quit")){
				done=true;
			}else{
				out.println("Echo"+sc.nextLine());
			}
		}
		serversocket.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
