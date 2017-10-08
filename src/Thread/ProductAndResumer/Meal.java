package Thread.ProductAndResumer;

//产品
public class Meal {
	//第几号食物
	private final int num;
	public Meal(int num){
		this.num=num;
	}
	public String toString(){
		return "食物"+num;
	}
}
