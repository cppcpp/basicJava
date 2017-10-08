package javaDesignpatterns.Bridge;

public class Bus extends AbstractCar{
	@Override
	void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("公交车");
	}
}
