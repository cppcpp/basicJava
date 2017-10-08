package Chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
	
	/*
	 * ���������͵���������
	 * �������Ƕ�������
	 * ��Ϊint[]����ת��Object����������ת�ɶ�������
	 * 
	 * */
	public static void main(String[] args) {
		int[] i={1,2,3};
		i=(int[]) copyOf(i,10);
		System.out.println(Arrays.toString(i));
	}
	
	public static Object copyOf(Object obj, int newLength){
		Class a=obj.getClass();
		if(!a.isArray()){
			return null;
		}
		
		Class component=a.getComponentType();//���ر�ʾ����������͵�class�࣬����������飬����null
		int length=Array.getLength(obj);//Array�ľ�̬�������õ�length
		
		Object newArray=Array.newInstance(component, newLength);//�����µ�����
		
		System.arraycopy(obj, 0, newArray, 0, Math.min(length, newLength));
		
		return newArray;
		
		
	}
}
