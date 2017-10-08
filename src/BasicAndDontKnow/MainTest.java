package BasicAndDontKnow;

/*
 * 运行程序：
 * java MainTest "123 45" lisa bily
 * 输出：
 * 第0个值：123 45
 * 第1个值：lisa
 * 第2个值：bily
 * 
 * */
public class MainTest {
	public static void main(String[] args) {
		for(int i=0;i<args.length;i++){
			System.out.println("第"+i+"个值："+args[i]);
		}
	}
}
