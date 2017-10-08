package Chapter5;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * java内省Introspection：java JDK中提供一套方法访问JavaBean的get，set方法
 * */
public class IntrospectionTest {
	
	
	public static void main(String[] args) {
		try {
			Class userClass=Class.forName("Chapter5.User");
			User user=(User) userClass.newInstance();
			
			BeanInfo beanInfo=Introspector.getBeanInfo(userClass);
			//得到有getset方法的属性列表
			PropertyDescriptor[] pros= beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor pro:pros){
				System.out.println("--属性"+pro.getName());
				
				if(pro.getName().equals("name")){
					//得到写方法
					System.out.println("执行name的写方法");
					Method setMethod= pro.getWriteMethod();
					setMethod.invoke(user, "张三");
				}else if(pro.getName().equals("number")){
					//得到写方法
					Method setMethod= pro.getWriteMethod();
					setMethod.invoke(user, 1);
				}
				
				if(pro.getName().equals("name")||pro.getName().equals("number")){
					//得到读方法
					Method getMethod=pro.getReadMethod();
					System.out.println("get方法："+getMethod.invoke(user)); 
					
				}
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}



