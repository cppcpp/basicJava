package Entity;

import java.util.Date;
import java.util.GregorianCalendar;


//实现深clone
public class Employee implements Cloneable {
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String name,double salary){
		this.name=name;
		this.salary=salary;
		this.hireDay=new Date();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHireday() {
		return hireDay;
	}
	
	//根据提供的值设置录用时间
	public void setHireday(int year,int month,int day) {
		Date newHireDay=new GregorianCalendar(year, month, day).getTime();
		hireDay.setTime(newHireDay.getTime());
	}
	
	public void raiseSalary(double byPercent){
		double raise=salary * byPercent/100;
		salary+=raise;
	}
	
	//声明异常，只要方法中含有未实现cloneable接口的类，就抛出异常
	public Employee clone() throws CloneNotSupportedException{
		Employee clone=(Employee) super.clone();//Object.clone()
		//可变子对象的克隆，，，String是不可变对象，因此不需要
		clone.hireDay=(Date) hireDay.clone();
		
		return clone;
		
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}
	
	
	
}
