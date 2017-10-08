package Chapter12Generic;

import java.awt.Component;
import java.util.Dictionary;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.plaf.SliderUI;

/*
 * ͨ�õ��ҳ����ֵ����Сֵ�ķ���
 * 
 * */
public class GenericCompare {
	private int X=1;
	private int Y=2;
	private int Z=3;
	public enum size{a,b,c};
	
	//ö������---ʵ�����Ƕ�����һ��ö�ٵ���
	public enum s{
		SMALL("s"),MEDIUM("M"),LARGE("L");
		private String s;
		
		private s(String size){
		this.s=size;
	}
	
	}
	
	public static void main(String[] args) {
		
		GregorianCalendar calendar1=new GregorianCalendar(2011, 11, 12);
		GregorianCalendar calendar2=new GregorianCalendar(2012, 2, 3);
		GregorianCalendar calendar3=new GregorianCalendar(1034, 3, 3);
		
		//ʵ���У�����ʡ�����Ͳ�������Ϊϵͳ���Բ²��
		Pair<GregorianCalendar> minmax= ArrayCompare.<GregorianCalendar>minmax(calendar1,calendar2,calendar3);
		System.out.println("��Сֵ��"+minmax.getFirst().getTime()+"    ���ֵ��"+minmax.getSecond().getTime());
		
		
		Dictionary<Integer,Component> labelTable=new Hashtable();
		labelTable.put(0,new JLabel(new ImageIcon()));
		JSlider slide=new JSlider();
		slide.setLabelTable(labelTable);

		//java��֧�ַ������͵�����
		//Pair<Object>[] table=new Pair<Object>[10];//ERROR������ʵ������������������
		
		
		
		
	}
}

class ArrayCompare{
	//��κ���---��Ѳ����������
	//extend���Ǽ̳У�������ʾT�Ǹð����͵�������
	//<T extends Comparable>���Ͳ���
	/*
	 * �ɱ��������Ƿ�����Ļ�����Υ���ˡ�Java����ʵ������������Ĺ��򡱣������������@SafeVarargsע������
	 * */
	
	@SafeVarargs
	public static <T extends Comparable> Pair<T> minmax(T...t){
		T min=t[0];
		T max=t[0];
		for(T value:t){
			if(min.compareTo(value)>0){
				min=value;
			}
			if(max.compareTo(value)<0){
				max=value;
			}
			
		}
		
		return new Pair<>(min,max);
	}
}


//���巺����   T-----���Ͳ���
class Pair<T>{
	private T first;
	private T second;
	
	//Cannot make a static reference to the non-static type T
	//��ֹʹ�ô������ͱ����ľ�̬���̬����
	//private static T a;
	
	
	public Pair(){
		first=null;
		second=null;
	}
	
	public Pair(T first,T second){
		this.first=first;
		this.second=second;
	}
	
	
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public T getSecond() {
		return second;
	}
	public void setSecond(T second) {
		this.second = second;
	}
	
	//����Ϊequals��������ͻ-------��Ϊ�������ͺ��Object.equals()������ͻ
	public boolean equal(T value){
		return first.equals(value)&&second.equals(value);
	}
	
}