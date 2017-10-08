package javaDesignpatterns.proxyMode;

public class Proxy implements Sourceable{
	private Source source;
	public Proxy(Source source) {
		this.source=source;
	}
	@Override
	public void method() {
		System.out.println("代理类中在源方法执行前执行方法");
		source.method();
		System.out.println("代理类中在源方法执行后执行方法");
	}
	
}
