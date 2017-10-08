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
 * 通用的找出最大值和最小值的方法
 * 
 * */
public class GenericCompare {
	private int X=1;
	private int Y=2;
	private int Z=3;
	public enum size{a,b,c};
	
	//枚举类型---实际这是定义了一个枚举的类
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
		
		//实际中，可以省略类型参数，因为系统可以猜测出
		Pair<GregorianCalendar> minmax= ArrayCompare.<GregorianCalendar>minmax(calendar1,calendar2,calendar3);
		System.out.println("最小值："+minmax.getFirst().getTime()+"    最大值："+minmax.getSecond().getTime());
		
		
		Dictionary<Integer,Component> labelTable=new Hashtable();
		labelTable.put(0,new JLabel(new ImageIcon()));
		JSlider slide=new JSlider();
		slide.setLabelTable(labelTable);

		//java不支持泛型类型的数组
		//Pair<Object>[] table=new Pair<Object>[10];//ERROR不允许实例化，但是允许声明
		
		
		
		
	}
}

class ArrayCompare{
	//变参函数---会把参数变成数组
	//extend不是继承，，，表示T是该绑定类型的子类型
	//<T extends Comparable>类型参数
	/*
	 * 可变参数如果是泛型类的话，就违反了“Java不能实例化泛型数组的规则”，，这里可以用@SafeVarargs注解消除
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


//定义泛型类   T-----类型参数
class Pair<T>{
	private T first;
	private T second;
	
	//Cannot make a static reference to the non-static type T
	//禁止使用带有类型变量的静态域或静态方法
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
	
	//命名为equals方法名冲突-------因为擦除类型后和Object.equals()方法冲突
	public boolean equal(T value){
		return first.equals(value)&&second.equals(value);
	}
	
}