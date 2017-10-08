package BasicAndDontKnow;

/*
 * 动态调用中的this指的是上一级的类
 * 
 * */
public class HttpServlet {
	private HttpServlet aString;
	public void service(){
		System.out.println("HttpServlet.service()");
		System.out.println("HttpServlet this:"+this);
		doGet();
	}
	
	public void doGet(){
		System.out.println("HttpServlet.doGet");
	}

	public String toString() {
		//aString=this;/////////////////why  报错
		return "HttpServlet aString=" + aString + "]";
	}

	
	
	
	
}
