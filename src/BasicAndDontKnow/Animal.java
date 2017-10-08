package BasicAndDontKnow;

public abstract class Animal {
	public Animal(){
		System.out.println("abstract Animal");
	}
	public abstract void run();
	
	public void breate(){
		System.out.println("breath");
		//这里的this其实是指向子类对象
		System.out.println("Animal this:"+this);
		this.run();
	}
	
}
