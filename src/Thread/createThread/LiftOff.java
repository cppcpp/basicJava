package Thread.createThread;

public class LiftOff implements Runnable{
	protected int countDown=10;//默认countDown为10
	private static int taskCount=0;
	private final int id=taskCount++;
	
	public LiftOff(int countDown) {
		this.countDown=countDown;
	}
	
	public LiftOff() {
		System.out.println("LiftOff()-------");
	}

	public String Status(){
		return "#"+id+"("+(countDown>0?countDown:"ListOff")+")";
	}
	public void run() {
		while(countDown-->0){
			System.out.print(Status()+"  ");
		}
		System.out.println();
	}
	

}
