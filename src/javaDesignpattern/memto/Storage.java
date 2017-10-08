package javaDesignpattern.memto;

/*
 * 存放备忘录
 * */
public class Storage {
	public Memento memento;
	public Storage(Memento memento){
		this.memento=memento;
	}
}
