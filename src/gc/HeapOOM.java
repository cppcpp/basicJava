package gc;

import java.util.ArrayList;
import java.util.List;

/*
 * 模拟堆溢出
 * 1.设置虚拟机参数：
 * 	-Xms:20m（将 堆最小值设为20m） -Xmx:20m（将堆最大值设为20m，避免堆的自动扩展） -XX:+HeapDumpOnOutOfMemoryError
 * （可以让虚拟机出现内存溢出时Dump出当前的内存堆转储快照以便事后进行分析）
 * 	
 * 2.出现异常
 * 
 * 
 * */
public class HeapOOM {
	static class OOMObject{
		
	}  
	
	public static void main(String[] args) {
		List<OOMObject> list=new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
		
	}
}
