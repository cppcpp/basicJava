package cloneTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Husband implements Cloneable,Serializable{
	private Wife wife;
	private int age;
	
	public Husband(Wife wife, int age) {
		super();
		this.wife = wife;
		this.age = age;
	}
	public Wife getWife() {
		return wife;
	}
	public int getAge() {
		return age;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//浅克隆
	public Object clone(){
		Husband husband=null;
		try {
			husband=(Husband) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			return husband;
		}
	}
	
	//深克隆
	public Object deepClone() throws IOException, ClassNotFoundException{
		//将对象写到流中
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream obs=new ObjectOutputStream(baos);
		obs.writeObject(this);
		
		//立即将对象取出
		ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bais);
		return ois.readObject();
	}
}
