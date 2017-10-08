package Chapter11Throwable;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Logging {
	//������־��¼��
	Logger logger=Logger.getLogger("Chapter11/Logging");
	public Logging(){
		System.out.println(this.getClass().getClassLoader().getResource("").getPath());
		logger.info("��¼�����FINE�����ϴ���");
		//�ƹ������ļ�������Ĭ����־��¼����
		logger.setLevel(Level.FINE);
		//�ƹ������ļ�-----���ô���������????????????????????????????????û�иĳɹ�
		Handler handler=new ConsoleHandler();
		handler.setLevel(Level.FINE);
		//��ϣ���ڿ���̨�����־��Ϣ
		logger.setUseParentHandlers(false);
		
		logger.addHandler(handler);
		
		//��װ�Լ��Ĵ�����
		try {
			FileHandler fileHandler=new FileHandler();
			System.out.println(fileHandler.getFormatter());
			logger.addHandler(fileHandler);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		LogManager logManager=LogManager.getLogManager();
		System.out.println(logManager.getProperty("java.util.logging.ConsoleHandler.level"));
	}
	public static void main(String[] args) {
		new Logging();
	}
}
