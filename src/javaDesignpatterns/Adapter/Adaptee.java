package javaDesignpatterns.Adapter;
/*
 * 等待被适配类
 * 已存在的，具有特殊功能的，但是不符合我们要求的类
 * */
public class Adaptee {
	public void method1(){
		System.out.println("已存在的，具有特殊功能的，但是不符合我们要求的类");
	}
}
