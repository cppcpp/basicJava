package Thread.interrupt;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 普通的Io阻塞，不可中断（就是还停留在阻塞状态，不能跳出阻塞状态）
 * 还有锁，，也是不可中断的
 * 
 * sleep阻塞是可中断的，可以跳出阻塞状态
 * 
 * 
 * nio自动响应中断 
 * 
 * */
class NIOBlocked implements Runnable{
	private final SocketChannel channel;
	public NIOBlocked(SocketChannel socketChannel){
		this.channel=socketChannel;
	}
	
	public void run() {
		try {
			System.out.println("waiting for read() in:"+this);
			channel.read(ByteBuffer.allocate(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exiting NIOBlocked.run()");
	}
}
public class NIOInterruption {
	public static void main(String[] args) {
		ExecutorService es=Executors.newCachedThreadPool();
		
		try {
			ServerSocket serverSocket=new ServerSocket(8080);
			InetSocketAddress isa=new InetSocketAddress("localhost", 8080);
			
			SocketChannel channel1=SocketChannel.open(isa);
			SocketChannel channel2=SocketChannel.open(isa);
			
			//将中断发送给一个特定的线程
			Future<?> future=es.submit(new NIOBlocked(channel1));
			es.execute(new NIOBlocked(channel2));
			
			//中断任务
			es.shutdown();
			future.cancel(true);
			
			//关闭底层资源来释放锁
			channel2.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
