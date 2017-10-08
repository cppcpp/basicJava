package javaDesignpattern.memto;


public class Memento {
	public String string;
	public Memento(String string){
		this.string=string;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	
}
