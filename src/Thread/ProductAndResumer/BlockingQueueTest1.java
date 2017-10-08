package Thread.ProductAndResumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import Thread.createThread.LiftOff;

public class BlockingQueueTest1 {
	static void getKey(){
		try {
			new BufferedReader((new InputStreamReader(System.in))).readLine();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	static void getKey(String message){
		System.out.println(message);
		getKey();
	}
	
	static void test(String message,BlockingQueue<LiftOff> queue){
		System.out.println(message);
		LiftOffRunnable runner=new LiftOffRunnable(queue);
		Thread t=new Thread(runner);
		t.start();
		
		for(int i=0;i<5;i++)
			runner.add(new LiftOff(5));
		getKey("Press 'Enter' ("+message+")");
		t.interrupt();
		System.out.println("Finished"+message+"test");
		
	}
	
	public static void main(String[] args) {
		test("LinkedBlockingQueue",new LinkedBlockingQueue<>());
	}
}

//消费者
class LiftOffRunnable implements Runnable{
	private BlockingQueue<LiftOff> rockets;
	public LiftOffRunnable(BlockingQueue<LiftOff> rockets){
		this.rockets=rockets;
	}
	public void run() {
		while(!Thread.interrupted()){
			try {
				rockets.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void add(LiftOff liftOff){
		try {
			rockets.put(liftOff);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Waking from take()");
		}
		
		System.out.println("Exiting LiftOffRunner()");
	}
}