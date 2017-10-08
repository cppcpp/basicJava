package gc;

/*
 * 设置虚拟机参数：
 * -verbose:gc -Xms20M -Xmx20M(最大堆，最小堆都为20M) -Xmn10M(新生代大小为10M) -XX:+PrintGCDetails(gc时打印日志) -XX：SurvivorRatio=8(决定了Eden区和survivor比例：8:1)
 * 
 * */
public class MinorGCTest {
	private static final int _1M=1024*1024;
	public static void main(String[] args) {
		byte[] allocation1,allocation2,allocation3,allocation4;
		
		allocation1=new byte[2*_1M];
		allocation2=new byte[2*_1M];
		allocation3=new byte[2*_1M];
		allocation4=new byte[4*_1M];//MinorGC
		
	}
}
