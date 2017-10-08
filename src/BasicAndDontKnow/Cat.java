package BasicAndDontKnow;


public class Cat extends Animal{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("cat run");
	}
	public static void main(String[] args) {
		//实例化抽象类，实现里面的抽象方法
		Animal animal=new Animal() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("run");
			}
		};
		animal.breate();
	}
}
