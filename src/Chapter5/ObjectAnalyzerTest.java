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
			//"WHEN_FOCUSED"��JComponent��һ����
			Field f=cs.getField("WHEN_FOCUSED");
			
			
			//ǿ���Field f.get(Object obj)����������ȡ�õ�ǰ�����е�ֵ������ǻ����������ͣ���getInt(),,,
			//�����FieldΪ˽�У�����setAccessible()���Ƿ���Ȩ��
			Object o= f.get(jc);
			System.out.println("WHEN_FOCUSED�е�ֵ"+o);
			
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
		 * Ӧ�ã�һ��ͨ�õ�toString��������
		 * */
		
	}

}
