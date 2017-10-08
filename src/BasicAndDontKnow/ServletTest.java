package BasicAndDontKnow;


public class ServletTest {
	public static void main(String[] args) {
		
		//Object servlet=new HttpServlet();
		HttpServlet servlet=new MyServlet();
		servlet.service();
		System.out.println(servlet.toString());
		//servlet.service();
		
		//System.out.println(servlet.toString());
	}
}
