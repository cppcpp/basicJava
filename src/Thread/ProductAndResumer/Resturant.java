package Thread.ProductAndResumer;
/*
 * 生产者，消费者模型
 * 
 * 
 * 
 * 
 * */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Resturant {
	Meal meal;
	Chef chef;
	Waiter  waiter;
	ExecutorService executorService=Executors.newCachedThreadPool();
	
	public Resturant(){
		chef=new Chef(this);
		waiter=new Waiter(this);
		executorService.execute(chef);
		executorService.execute(waiter);
	}
	public static void main(String[] args) {
		new  Resturant();
	}
	
}
