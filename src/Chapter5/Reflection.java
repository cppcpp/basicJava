package Chapter5;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class Reflection{

	public static void main(String[] args) {
		/*
		 * ���ַ������Class�����
		 * */
		
		String s=new String();
		//1.�õ������Class���͵�ʵ�������������ȡ�������
		Class sc=s.getClass();
		String name=sc.getName();
		//System.out.println(name);

		try {
			//2.��̬����class.forName()ͨ��������ô����ʵ��,�����������������߽ӿ���
			Class cc= Class.forName("java.lang.String");
			//newInstance����Ĭ���޲ι��캯�������û�У����쳣��
			Object oc= cc.newInstance();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.���T����������Java���ͣ�**�������δ����һ���࣬����int**����T.class������ƥ��������
		//Java8�л������ͣ�byte,int,short,long,float,double,cahr,boolean
		Class c1=int.class;
		Class c2=String.class;
		Class c3=Data.class;
		
		
		
		
		
		
		
		/*
		 * Ӧ�ã��û����������������������ȫ����Ϣ
		 * */
		//java.lang.reflect������Ҫ�������ࣺField��Method��Constrauctor
		 System.out.println("please input a class name��");
		 Scanner in=new Scanner(System.in);
		 String className= in.next();
		 try {
			Class c11=Class.forName(className);
			Class c22=c11.getSuperclass();//�õ�cll�ĸ���
			
			//getModifiers()�õ����η����������α�ʾ�ģ���ҪModifer.toString()ת���ַ���
			String modifers=Modifier.toString(c11.getModifiers());
			if(modifers.length()>0){
				System.out.print(modifers+" class "+className);				
			}
			
			//�Ƿ��и��ࣨ�ų�Object��
			if(c22!=null&&c22!=Object.class){
				System.out.print(" extends "+c22);
			}
			System.out.println("{\n");
			//��ӡ���캯��
			System.out.println("//���캯��");
			printConstructers(c11);
			//��ӡ����
			System.out.println("//����");
			printFields(c11);
			//��ӡ����
			System.out.println("//����");
			printMethods(c11);
			System.out.print("}");
		 } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

	public static void printConstructers(Class cname){
		//����cname����������й��캯��������
		//Constructor[] cons=cname.getConstructors();//��������
		Constructor[] cons=cname.getDeclaredConstructors();//����������
		for(Constructor con:cons){
			//���η�
			System.out.print("  "+Modifier.toString(con.getModifiers())+" "+con.getName()+"(");
			
			//����
			//Parameter[] pars=con.getParameters();//���ַ����޷��ó�����Ĳ��������ˣ�ֻ��һ��Object
			Class[] pars= con.getParameterTypes();
			
			for(int i=0;i<pars.length;i++){
				System.out.print(pars[i].getName()+" ");
			}
			System.out.print(");");
			System.out.println();
		}
		System.out.println("\n\n");
	}
	
	
	public static void printFields(Class cName){
		Field[] fields=cName.getFields();
		for(Field f:fields){
			System.out.print("  ");
			//���η�
			System.out.print(Modifier.toString(f.getModifiers()));
			//����
			System.out.println(" "+f.getName()+";");
			System.out.println();
		}
		System.out.println("\n\n");
	}
	
	public static void printMethods(Class cName){
		Method[] methods=cName.getMethods();
		for(Method method:methods){
			System.out.print("  ");
			//���η�������
			System.out.print(Modifier.toString(method.getModifiers())+" "+method.getName());
			System.out.print("(");
			//����
			Class[] params=method.getParameterTypes();
			for(int i=0;i<params.length;i++){
				if(i!=params.length-1){
					System.out.print(Modifier.toString(params[i].getModifiers()));
					System.out.print(" "+params[i].getName()+",");
				}
			}
			System.out.print(");");
			System.out.println();	
		}
		
	}
}
