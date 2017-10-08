package Entity;

import java.util.Date;
import java.util.GregorianCalendar;


//ʵ����clone
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
	
	//�����ṩ��ֵ����¼��ʱ��
	public void setHireday(int year,int month,int day) {
		Date newHireDay=new GregorianCalendar(year, month, day).getTime();
		hireDay.setTime(newHireDay.getTime());
	}
	
	public void raiseSalary(double byPercent){
		double raise=salary * byPercent/100;
		salary+=raise;
	}
	
	//�����쳣��ֻҪ�����к���δʵ��cloneable�ӿڵ��࣬���׳��쳣
	public Employee clone() throws CloneNotSupportedException{
		Employee clone=(Employee) super.clone();//Object.clone()
		//�ɱ��Ӷ���Ŀ�¡������String�ǲ��ɱ������˲���Ҫ
		clone.hireDay=(Date) hireDay.clone();
		
		return clone;
		
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}
	
	
	
}
