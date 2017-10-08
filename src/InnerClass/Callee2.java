package InnerClass;

/*
 *第二种，用内部类实现接口 
 * */
public class Callee2 extends MyInrement{
	private int i=0;
	public void increment() {
		super.increment();
		i++;
		System.out.println(i);
	}
	
	//内部类      实现接口
	//内部类实现闭包----记录一些信息，来自于创建它的作用域
	private class Closure implements Incrementable{

		@Override
		public void increment() {
			//调用外围类的方法      接口与接口的实现完全独立
			Callee2.this.increment();
		}
	}
	
	//回调：稍后的某个时刻调用初始的对象
	Incrementable getCallbackReference(){
		return new Closure();
	}
}
