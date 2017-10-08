package javaDesignpattern.Mediator;

public class User2 extends User{
	private Mediator mediator;
	public User2(Mediator mediator) {
		super(mediator);
		this.mediator=mediator;
	}

	@Override
	public void talk() {
		System.out.println("你好，这里是用户2");
	}

}
