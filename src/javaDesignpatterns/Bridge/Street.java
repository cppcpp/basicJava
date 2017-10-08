package javaDesignpatterns.Bridge;

public class Street extends AbstractRode{
	@Override
	public void road() {
		// TODO Auto-generated method stub
		super.road();
		System.out.println("街道");
		//对应的汽车
		car.run();
	}
}
