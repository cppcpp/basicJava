package BasicAndDontKnow;

public class Test3 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		float float1=0.12f;
		System.out.println(float1);
		short short1=1;
		//short1=short1+1;    //将int转换成short类型，错
		short1+=1;//隐含强制的类型转换
		System.out.println(short1);
		
		//自动装箱与自动拆箱
		Integer a=1;//将1自动装箱成Integer类型
		Integer b=new Integer(1);
		int c=1;
		System.out.println(a==b);//两个是引用的是不同的对象
		System.out.println(c==a);//自动拆箱后比较
		System.out.println(b==c);
		Integer aInteger=1,bInteger=1,cInteger=127,dInteger=127;
		System.out.printf("a==b:%s\n",aInteger==bInteger);
		//根据源码：：当Integer的范围 在-128~127之间时，不会newInteger对象，而是自动引用常量池中的 Integer对象
		System.out.printf("c==d:%s\n",cInteger==dInteger);
		
		//& & &&
		boolean aboolean=true,bboolean=true;
		System.out.println(aboolean&&bboolean);
		
		//Math   round:四舍五入，返回最接近的整形   
		//四舍五入原理：+0.5，然后进行下取整
		System.out.println(Math.round(1.5)+ "   "+Math.round(-1.5));
	
		//用最有效率的方法计算2*8
		System.out.printf("最有效率的方式2*8：2<<3:%s\n",2<<8);
		
		String string[]={"123","234","343"};
		int length=string.length;
		string[1].length();
		Person person=new Person(10, "张三");
		grow(person);
		System.out.println(person.toString());
		
	}
	
	public static void grow(Person person){
		person.setAge(person.getAge()+1);
	}
}

class Person{
	private int age;
	private String name;
	
	public Person(int age,String name){
		this.age=age;
		this.name=name;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "person [age=" + age + ", name=" + name + "]";
	}
	
	
}