package NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class SimpleUserOfChannel {
	public static void main(String[] args){
		try {
			RandomAccessFile randomFile;
			randomFile = new  RandomAccessFile("src\\employee.txt", "rw");
			FileChannel inChannel= randomFile.getChannel();
			
			ByteBuffer byteBuffer=ByteBuffer.allocate(10);
			
			//从通道中读一组字节序列到缓存中
			int bytesRead=inChannel.read(byteBuffer);
			
			while(bytesRead!=-1) {
				System.out.println("Read"+bytesRead);
				
				//从buffer中读取数据
				byteBuffer.flip();
				
				while(byteBuffer.hasRemaining()) {
					System.out.println("buf:"+(char)byteBuffer.get());
				}
				
				byteBuffer.clear();
				bytesRead=inChannel.read(byteBuffer);
			}
			
			randomFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
