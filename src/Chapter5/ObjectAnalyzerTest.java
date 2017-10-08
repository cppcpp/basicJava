package Chapter5;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComponent;

public class ObjectAnalyzerTest {
	public static void main(String[] args) {
		
		JComponent jc=new JComponent() {
		};
		
		Class cs=jc.getClass();
		/*Field[] fs=cs.getFields();
		for(Field ff:fs){
			System.out.println("fields::"+ff.getName());
		}*/
		
		try {
			//"WHEN_FOCUSED"是JComponent的一个域
			Field f=cs.getField("WHEN_FOCUSED");
			
			
			//强大的Field f.get(Object obj)方法，可以取得当前对象中的值，如果是基本数据类型，就getInt(),,,
			//如果此Field为私有，方法setAccessible()覆盖访问权限
			Object o= f.get(jc);
			System.out.println("WHEN_FOCUSED中的值"+o);
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		/*
		 * 
		 * 应用：一个通用的toString（）方法
		 * */
		
	}

}
