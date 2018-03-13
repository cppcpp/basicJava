package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test {
	
	public void selector() throws IOException {
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		Selector selector=Selector.open();
		ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);//设为非阻塞方式
		serverSocketChannel.socket().bind(new InetSocketAddress(8080));
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		while(true) {
			Set selectedKeys=selector.selectedKeys();
			Iterator iterator=selectedKeys.iterator();
			
			while(iterator.hasNext()) {
				SelectionKey key=(SelectionKey) iterator.next();
				
				if((key.readyOps()&SelectionKey.OP_ACCEPT)==SelectionKey.OP_ACCEPT) {
					ServerSocketChannel ssChannel=(ServerSocketChannel) key.channel();
					
					SocketChannel sc=ssChannel.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
					iterator.remove();
				}else if((key.readyOps() & SelectionKey.OP_ACCEPT)==SelectionKey.OP_READ) {
					SocketChannel sc=(SocketChannel) key.channel();
					while(true) {
						buffer.clear();
						int n=sc.read(buffer);
						if(n<=0) {
							break;
						}
						buffer.flip();
					}
					iterator.remove();
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
