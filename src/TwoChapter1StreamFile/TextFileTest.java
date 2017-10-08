package TwoChapter1StreamFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * 写入写出文本文件
 * 
 * 定义数组，写到employee.txt中---
 * 得到输出流
 * */
public class TextFileTest {

	public static void main(String[] args) {
		Employee[] staff=new Employee[4];
		staff[0]=new Employee("tom",6000.0,new Date());
		staff[1]=new Employee("jack",7000.0,new Date());
		staff[2]=new Employee("rose",8000.0,new Date());
		staff[3]=new Employee("hanse",9000.0,new Date());	
		
		try(PrintWriter out=new PrintWriter(new FileWriter("src\\employee.txt"))){
			//写到文本文件中
			writeEmployee(staff,out);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//从文本文件输出到数组
		try(Scanner in=new Scanner(new FileInputStream("src\\employee.txt"))){
			Employee[] newStaff =readTextFile(in);
			System.out.println("newStaff  Length::"+newStaff.length);
			for(int i=0;i<newStaff.length;i++){
				System.out.println(newStaff[i].toString());
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static void writeEmployee(Employee[] staff,PrintWriter out){
		out.println("The number 0f stuff:"+staff.length);
		for(Employee employee:staff){
			GregorianCalendar calendar=new GregorianCalendar();
			calendar.setTime(employee.getHireday());
			out.println(employee.getName()+"|"
					+employee.getSalary()+"|"
					+calendar.get(Calendar.YEAR)+"|"
					+calendar.get(Calendar.MONTH)+"|"
					+calendar.get(Calendar.DAY_OF_MONTH));
			
		}
	}
	
	
	public static Employee[] readTextFile(Scanner in){
		String str=in.nextLine();
		String[] str2=str.split(":");
		int length=Integer.parseInt(str2[1]);
		System.out.println("length:"+length);
		
		Employee[] staff=new Employee[length];
		for(int i=0;i<length;i++){
			staff[i]=readEmployee(in);
			System.out.println("第"+i+"个:"+staff[i]);
		}
		
		System.out.println("------------------------");
		for(Employee emp:staff){
			emp.toString();
		}
		System.out.println("--------------------------");
		return staff;
	}
	
	
	public static Employee readEmployee(Scanner in){
		String emp=in.nextLine();
		String[] empAll=emp.split("\\|");
		String name=empAll[0];
		double salary=Double.parseDouble(empAll[1]);
		Date date=new Date(Integer.parseInt(empAll[2]),
				Integer.parseInt(empAll[3]),
				Integer.parseInt(empAll[4]));
		Employee employee=new Employee(name,salary,date);
		System.out.println(employee.toString());
		return employee;
	}
	
}


class Employee{
	
	private String name;
	private Double salary;
	private Date hireday;
	
	
	public Employee(String name, Double salary, Date hireday) {
		super();
		this.name = name;
		this.salary = salary;
		this.hireday = hireday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getHireday() {
		return hireday;
	}
	public void setHireday(Date hireday) {
		this.hireday = hireday;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hireday=" + hireday + "]";
	}
		
}


