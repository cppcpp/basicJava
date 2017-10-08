package BasicAndDontKnow;

public class MyServlet extends HttpServlet{
	public void doGet(){
		System.out.println("MyServlet this:"+this);//这里的this都是指的上一级对象
		System.out.println("Myservlet.doGet()");
	}
}
