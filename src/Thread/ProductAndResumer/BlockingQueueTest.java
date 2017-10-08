package Thread.ProductAndResumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import Thread.createThread.LiftOff;

public class BlockingQueueTest {
	public static void main(String[] args) {
		LiftOffRunner liftOffRunner = new LiftOffRunner(new LinkedBlockingQueue<LiftOff>(), new LiftOff(5));
	}
}

class LiftOffRunner {
	private BlockingQueue<LiftOff> blockingQueue;

	public LiftOffRunner(BlockingQueue<LiftOff> blockingQueue, LiftOff liftOff) {
		this.blockingQueue = blockingQueue;

		// 开启内部类线程--消费  队列中的  对象，如果没有的话，队列可以挂起消费者队列
		Thread thread = new Thread(new Inner());
		thread.start();

		for (int i = 0; i < 5; i++)
			blockingQueue.add(liftOff);

		// 中断立即中断
		// thread.interrupt();
	}

	public void add(LiftOff liftOff) {
		try {
			blockingQueue.put(liftOff);
			System.out.println("放入：" + liftOff.Status());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class Inner implements Runnable {

		public void run() {
			try {
				while (!Thread.interrupted()) {
					// 从队列中取出一个元素
					System.out.println(blockingQueue.take());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Waking from take()");
			}
		}
	}
}
