package InnerClass;

//继承内部类
public class InheritInner extends WithInner.Inner{
	//默认构造器不算好，而且不能只提供指向外围类的引用
	//需要使用一下语法：enclosingClassRefrence.super()
	public InheritInner(WithInner withInner){
		withInner.super();
	}
}

class WithInner{
	class Inner{
		
	}
}