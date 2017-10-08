package gc;

import javax.print.attribute.standard.MediaName;

/*
 * 模拟jvm  虚拟区栈    和     本地方法栈出现的异常
 * HotSpot虚拟机中并不区分虚拟机栈和本地方法栈，只能由-Xss设置栈的大小
 * 
 * 两种异常：
 * StackOverflowError：栈大小不够
 * OutOfMemoryError:内存大小不够
 * 
 * 次类只能演示StackOverflowError的异常
 * 1.使用-Xss减小栈内存的容量     ：-Xss128k
 * 2.定义大量的本地变量，以此增大虚拟机栈中“本地变量表”的长度
 * 
 * 实验结果表明：
 * 在单线程环境下，无论是栈帧太大，还是虚拟机栈的容量太小，抛出的都是StackOverflowError
 * */
public class JavaVMSOF {
	private int stackLength=1;
	
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMSOF jvs=new JavaVMSOF();
		try{
			jvs.stackLeak();
		}catch(Throwable t){
			System.out.println("stack length:"+jvs.stackLength);
			throw t;
		}
		
		
	}
	
}
