package javaDesignpattern.Mediator;

/*
 * 自己的中介者类
 * 持有要管理的类的对象
 * 类似qq平台管理用户间通话
 * 通过这个中介类来管理两个用户类
 * */
public class MyMediator implements Mediator{
	private User1 user1;
	private User2 user2;
	public void createMediator() {
		user1=new User1(this);
		user2=new User2(this);
	}

	@Override
	public void work() {
		user1.talk();
		user2.talk();
	}

}
