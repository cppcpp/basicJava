package javaDesignpatterns.proxyMode;

public class Source implements Sourceable{

	@Override
	public void method() {
		System.out.println("这是我们的源方法");
	}

}
