package InnerClass;

public class Caller {
	private Incrementable incrementable;
	public Caller(Incrementable incrementable){
		this.incrementable=incrementable;
	}
	public void go(){
		incrementable.increment();
	}
}
