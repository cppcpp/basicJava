package Chapter11Throwable;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingImageViewr {
	public static void main(String[] args) {
		if(System.getProperty("java.util.logging.config.class")==null&&
				System.getProperty("java.util.logging.config.file")==null){
			Logger.getLogger("com.cpp.corejava").setLevel(Level.ALL);
			final int LOG_ROTATION_COUNT=10;
			try {
				
				//ģʽ������%h---ϵͳ����user.home��ֵ
				Handler handler=new FileHandler("%h/LogginImageViewer.log",0,LOG_ROTATION_COUNT);
				Logger.getLogger("com.cpp/corejava").addHandler(handler);
				
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				Logger.getLogger("com.cpp.corejava").log(Level.SEVERE,"Can`t create log file handler", e);
			}
		}
		
		
	}
}
