package Chapter6;

import java.util.Scanner;

import Entity.Employee;

public class CloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * �������ͨclone����Ĭ��ǳ������
		 * 
		 * �����������Ͷ�����һ��public��clone��������
		 * 
		 * ��һ��kelong������Java�����л�����ȫ���׵���Ч����
		 * */
		try {
			Employee em=new Employee("nemo",12);
			em.setHireday(2001, 1, 3);
			Employee cloned=em.clone();
			cloned.setHireday(2002, 1, 3);
			
			System.out.println("original:"+em.toString());
			System.out.println("cloned:"+cloned);
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
