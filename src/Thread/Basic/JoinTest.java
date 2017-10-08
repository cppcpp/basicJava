package Thread.Basic;

public class JoinTest {
	public static void main(String[] args) {
		Sleep sleep=new Sleep("sleep", 3000);
		Joiner joiner=new Joiner(sleep, "Joiner");
		joiner.start();
		
		//对join的方法可以被中断，调用Interrupt方法
		sleep.interrupt();
	}
}

class Sleep extends Thread{
	private int duration;
	public Sleep(String name,int dutation){
		//调用父类的Thread(String name)的构造函数
		super(name);
		this.duration=dutation;
		start();
	}
	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			//这里显示没有被中断，，原因：在调用isInterrupt时，会被设置一个中断标志位，但是捕获异常时会清除这个标志
			System.out.println(this.getName()+"被阻塞"+duration+"毫秒"+"目前是否被中断："+isInterrupted());
			//return ;
		}
		System.out.println(getName()+"线程has awakened");
	}
}
class Joiner extends Thread{
	private Sleep sleep;
	private int count=5;
	public Joiner(Sleep sleep,String name){
		this.sleep=sleep;
	}
	@Override
	public void run() {
		while(true){
			System.out.println(this);
			if(count--==0)
				return;
			if(count==3){
				try {
					sleep.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(getName()+"is Interrupted");
				}
				System.out.println(getName()+"join 完成");
			}
		}
	}
	public String toString(){
		return getName()+":"+count;
	}
	
	
}

