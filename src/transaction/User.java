package transaction;

public class User {
	private int id;
	private String name;
	private String password;
	private double money;
	private int flag;
	
	public User(int id, String name, String password, double money,int flag) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.money = money;
		this.flag=flag;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public double getMoney() {
		return money;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
}
