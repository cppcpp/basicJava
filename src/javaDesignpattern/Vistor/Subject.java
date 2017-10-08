package javaDesignpattern.Vistor;


public interface Subject {
	public void accept(Vistor vistor);
	public String getSubject();
}
