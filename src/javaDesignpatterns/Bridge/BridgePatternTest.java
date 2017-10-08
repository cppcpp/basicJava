package javaDesignpatterns.Bridge;

/*
 * 以公路和车型为例：不同公路上跑不同车型
 * 将公路类和车型类分别抽象出来，公路类持有车型类的实例
 * 
 * */
public class BridgePatternTest{
	public static void main(String[] args) {
		AbstractCar car=new Bus();
		AbstractRode rode=new SpeedWay();
		rode.car=car;
		rode.road();
	}
}
