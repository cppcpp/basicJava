package Chapter11Throwable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogTest {
	private static final Logger myLogger=Logger.getLogger("com.mycompany.myapp");

	public static void main(String[] args) throws IOException {
		//ȡ��������־-------Level.OFFʵ�����ǹر������м������־��¼
		//Logger.getGlobal().setLevel(Level.OFF);
		
		myLogger.setLevel(Level.FINE);

		Logger.getGlobal().info("Log Begin");
		myLogger.warning("warning �������־����¼");
		//Ĭ��ֻ���¼INFO��Warning��severe�����������־��----��Ҫ��¼�����������־����Ҫ�ı���־������������
		myLogger.log(Level.FINE, "FINE �������־����¼");
		
		//��¼��־-------Ĭ����־��¼�����������ͷ���������������������ִ�й��̽������Ż����͵ò���׼ȷ�ĵ�����Ϣ
		//so��������logp��������
		myLogger.entering("Chapter11", "main");
		
		
		//����־��¼�쳣
		try {
			Scanner sc=new Scanner(new FileInputStream("readme.txt"));
		} catch (IOException e) {
			myLogger.getLogger("com.mycompany.myapp").log(Level.WARNING,"Reading File failure",e);
		}
		System.out.println(myLogger.getResourceBundleName());
		
		
	}

}
