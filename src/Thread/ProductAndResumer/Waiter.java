package Thread.ProductAndResumer;

import java.util.concurrent.TimeUnit;

//消费者
public class Waiter implements Runnable{
	private  Resturant resturant;
	
	public Waiter(Resturant resturant){
		this.resturant=resturant;
	}
	@Override
	public void run() {
		try{
			
			while(!Thread.interrupted()){
				//要把sleep放在上面，不这样，chef还在阻塞状态，waiter的wait出错
				TimeUnit.MILLISECONDS.sleep(1);
				//1.检差如果没有食物，挂起自己
				synchronized (this) {
					while(resturant.meal==null){
						try {
							this.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							
							e.printStackTrace();
						}
					}
				}
				
				//2.有食物，输出食物信息
				System.out.println("客人获得"+resturant.meal.toString());
				TimeUnit.MILLISECONDS.sleep(200);
				
				//3.食物吃完，通知厨师做菜
				synchronized (resturant.chef) {
					resturant.meal=null;
					resturant.chef.notifyAll();
				}
			}
		}catch(InterruptedException exception){
			System.out.println("服务生线程结束");
		}
		
	}
	
}
