package Thread.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * 用cylicbarrier模拟赛马
 * 
 * */
public class HorseRace {
	private final int FINSH_LINE=75; 
	private List<Horse> lists=new ArrayList<Horse>();
	ExecutorService service=Executors.newCachedThreadPool();
	public HorseRace(int nHorses){
		CyclicBarrier cyclicBarrier=new CyclicBarrier(nHorses,new Runnable() {
			@Override
			public void run() {
				//打印赛场的栅栏
				StringBuilder stringBuilder=new StringBuilder();
				for (int i = 0; i <FINSH_LINE; i++) {
					stringBuilder.append("=");
				}
				System.out.println(stringBuilder.toString());
				for(Horse horse:lists){
					System.out.println(horse.tracks());
				}
				for(Horse horse:lists){
					if(horse.getStraides()>=FINSH_LINE){
						System.out.println(horse+"won!!!!!!!!!!!!!!");
						//停止所有的线程
						service.shutdownNow();
						//安全结束
						return;
					}
				}
				try {
					TimeUnit.MICROSECONDS.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("barrierACtion sleep isInterrupted");
				}
				
			}
		});
		
		for (int i = 0; i < nHorses; i++) {
			Horse horse=new Horse(cyclicBarrier);
			lists.add(horse);
			service.execute(horse);
		}
	}
	public static void main(String[] args) {
		new HorseRace(5);
	}
	
	
}
class Horse implements Runnable{
	private static CyclicBarrier cyclicBarrier;
	private static int count=0;
	private final int id=count++;
	private Random random=new Random(47);
	//马的步伐长
	private int straid=0;
	
	public Horse(CyclicBarrier barrier){
		cyclicBarrier=barrier;
	}
	
	@Override
	public void run() {
		while(!Thread.interrupted()){
		try {
				synchronized (this) {
					//让马随机跑这么多步数0-10之间的步数
					int rand=random.nextInt(10);
					straid+=rand;
					//System.out.println(rand);
				}
				//阻塞住，直到所有马线程完成
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String toString(){
		return "Horse"+id;
	}
	
	public synchronized int getStraides(){
		return this.straid;
	}
	
	//打印马的轨迹路径
	public String tracks(){
		StringBuilder s=new StringBuilder();
		for (int i = 0; i < straid; i++) {
			s.append("*");
		}
		return s.toString();
	}
}
