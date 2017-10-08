package javaDesignpattern.Vistor;

public class MySubject implements Subject{

	@Override
	public void accept(Vistor vistor) {
		//调用接受vistor中的方法
		vistor.vistor(this);
	}

	@Override
	public String getSubject() {
		// TODO Auto-generated method stub
		return "当前科目是语文";
	}

}
