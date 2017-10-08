package javaDesignpattern.Mediator;

public class User1 extends User{
	private Mediator mediator;
	public User1(Mediator mediator) {
		super(mediator);
		this.mediator=mediator;
	}

	@Override
	public void talk() {
		System.out.println("你好，这里是user1");
	}

}
