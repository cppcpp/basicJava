package Thread.ProductAndResumer;

import java.util.concurrent.TimeUnit;

/*
 * 生产者消费者模型有四个对象：
 * 生产者（chef）
 * 消费者（waiter）
 * 仓库（resturant）
 * 产品（meal）
 * 
 * 此例展示单个产品的生产者与消费者
 * 生产者
 * 
 * */
public class Chef implements Runnable {
	private Resturant resturant;
	private int num = 0;

	public Chef(Resturant resturant) {
		this.resturant = resturant;
	}

	public void run() {
		try{
			while (!Thread.interrupted()) {
				// 1.检查餐厅中是否有食物,没有食物，chef自己进入等待状态
				synchronized (this) {
					while (resturant.meal!= null) {
						try {
							this.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				//2.设置食物超过十号，代表食材用完
				if(++num==4){
					System.out.println("食物已经卖完");
					resturant.executorService.shutdownNow();
				}
				
				System.out.println("订单已经到达厨房");
				
				//4.生产食物的时间
				TimeUnit.MILLISECONDS.sleep(100);
				
				//3.生产完食物，通知waiter线程可以取餐
				synchronized (resturant.waiter) {
					resturant.meal=new Meal(num);
					resturant.waiter.notifyAll();
				}
				
				
			}
		}catch(InterruptedException e){
			System.out.println("厨师线程结束");
		}
		

	}
}