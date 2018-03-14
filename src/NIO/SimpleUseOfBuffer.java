package NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * 使用Buffer的四个步骤：
 * （声明buffer，绑定到通道）
 * 1.写数据到Buffer
 * ---a.  int bytesRead=inChannel.read(buf)//read into buf
 * ---b.  buf.read(123);
 * 2.调用buffer.flip()//从写模式切换到度模式
 * --- 即将limit=position  position=0
 * 3.从buffer中读数据
 * ---a.  int bytesWrite=inChannel.write(buf)//从buf中读数据到channel
 * ---b.  buf.get()
 * 4.调用buffer.clear()或者buffer.compact()
 * ---buf.clear():positon=0,limit=capacity  “忘记”哪些数据读过，哪些没有
 * ---buf.compact():将未读过的数据都放在开头，position=最后一个数据后面
 * 
 * buf.rewind():position=0,limit不变，你可以重读buf中的所有数据
 * 
 * buf.mark():mark=positon:标记position
 * buf.reset():position=mark:重新回到之前的position
 * 
 * 
 * 
 * 其他几个基本函数：
 * buf.equals():比较剩余的值是否相等
 * ------ByteBuffer.equals()
 * 		 p=postion;
 * 		 for(int i=this.limit-1,int j=that.limit-1;i>=p;i--,j--)
 * buf.compare():
 * ------ByteBuffer.compareTo():
 *       n=positon+Math.min(this.remain,that.remain)
 *       //在剩余的值中
 *       for(i=this.position,j=that.position;i<n;i++)
 *       	//如果谁的值大，谁就大
 *       	int temp=if(compare(this.get(i),that.get(i)))
 *       	if(temp!=0)
 *       		return temp;
 *       //如果剩余值都相同，谁数据多谁就大
 *       return this.remain-that.remain;
 * */
public class SimpleUseOfBuffer {
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
					System.out.println("buf:"+(char)byteBuffer.get());//从buf中取数据
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
