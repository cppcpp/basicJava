package socket;

import java.io.IOException;
import java.net.InetAddress;

public class socket{
	public static void main(String[] args) throws IOException{
		InetAddress Inetaddress=InetAddress.getLocalHost();
		System.out.println("InetAddress:"+Inetaddress);
		System.out.println("getLocalhost£º"+Inetaddress.toString());
		System.out.print("ByteÊä³ölocalhostgetAddress£º");
		byte[] address=Inetaddress.getAddress();
		for(byte a:address){
			System.out.print(a);
		}
		System.out.println();
		System.out.println("toStringÊä³ölocalhostgetAddress:"+Inetaddress.getAddress().toString());
		
		InetAddress[] Inetaddress_server_array=InetAddress.getAllByName("time-A.timefreq.bldrdoc.gov");
		for(InetAddress Inetaddress_server:Inetaddress_server_array){
			//System.out.println("lalaal*******"+Inetaddress_server.getAddress().toString());
			System.out.println("byteÊä³ö£º");
			byte[] Inetaddress_server_byte=Inetaddress_server.getAddress();
			for(byte a:Inetaddress_server_byte){
				System.out.print(a);
			}
			
		}
	}
	
}
