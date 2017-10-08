package javaDesignpattern.memto;
/*
 * 备忘录模式：备份一个类的状态，并在一定条件下恢复
 * 
 * 角色：
 * 原始类（需要备份的 类）：持有备份类的实例
 * 备份类：对原始类中进行备份的类
 * 备忘录类：存放备忘类
 * 
 * 
 * */


public class MemtoTest {
	public static void main(String[] args) {
		Orginal orginal=new Orginal();
		orginal.setString("123");
		System.out.println("original本来值："+orginal.getString());
		//将string值存入备忘录中
		Memento memento= orginal.createMemeto();
		Storage storage=new Storage(memento);
		
		//改变值
		orginal.setString("234");
		System.out.println("orginal修改后的值："+orginal.getString());
		
		//恢复值
		orginal.restoreMemeto(memento);
		System.out.println("恢复后的值为："+orginal.getString());
		
		
	}
}
