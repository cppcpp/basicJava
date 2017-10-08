package cloneTest;

import java.io.Serializable;
import java.util.Date;

public class Wife implements Serializable{
	private String name;
	private Date birthday;
	
	
	public Wife(String name, Date birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
