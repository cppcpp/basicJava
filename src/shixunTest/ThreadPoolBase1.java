package shixunTest;import BasicAndDontKnow.TheadTest2;

public class ThreadPoolBase1 {
	public static void main(String[] args) {
		CountThread2 thread=new CountThread2();
		thread.start();
		synchronized (thread) {
			try {
				thread.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("sum:"+thread.getSum());
		
	}
}
class CountThread2 extends Thread{
	private int sum;
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			for(int i=0;i<5;i++){
				sum+=i;
			}
			
		}
	}
	
}
