package javaDesignpatterns.proxyMode;

/*
 * 代理工厂模式
 * 使用场景：对原有类中的方法进行改进，修改原有方法，违反“开闭原则”
 * 		所以采用一个代理类调用原有方法，且对结果产生控制
 * */
public class ProxyModeTest {
	public static void main(String[] args) {
		Source source=new Source();
		Proxy proxy=new Proxy(source);
		proxy.method();
	}
}
