package javaDesignpattern.memto;

public class Orginal {
	private String string;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	// 创建备忘录
	public Memento createMemeto() {
		return new Memento(this.string);
	}

	// 恢复备忘录中的string值
	public void restoreMemeto(Memento memeto) {
		this.string = memeto.getString();
	}
}
