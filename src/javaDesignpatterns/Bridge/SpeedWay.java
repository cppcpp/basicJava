package javaDesignpatterns.Bridge;

public class SpeedWay extends AbstractRode{
	@Override
	public void road() {
		// TODO Auto-generated method stub
		super.road();
		System.out.println("高速公路");
		car.run();
	}
}
