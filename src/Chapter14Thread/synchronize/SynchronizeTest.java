package Chapter14Thread.synchronize;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class SynchronizeTest {
	public static final int NACCOUNT=10;
	public static final double INITAL_BALANCE=2000;
	
	//线程的局部变量
	public static final ThreadLocal<SimpleDateFormat> dataFormat=
			new ThreadLocal<SimpleDateFormat>(){
			protected SimpleDateFormat initialValue(){
				return new SimpleDateFormat("yyyy-MM-dd");
			}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//首次调用get，执行initialValue函数，
		String dateStamp=dataFormat.get().format(new Date());
	
		//多个线程生成随机数--ThreadLocalRandom.current()返回针对当前线程的Ramdom类实例
		int random=ThreadLocalRandom.current().nextInt();

		Bank b=new Bank(NACCOUNT,INITAL_BALANCE);
		int i;
		for(i=0;i<NACCOUNT;i++){
			TransferRunnable r=new TransferRunnable(b, i, INITAL_BALANCE);
			Thread t=new Thread(r);
			t.start();
		}
				
				
			
				
	}
		
}
