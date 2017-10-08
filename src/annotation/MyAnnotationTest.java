package annotation;


import annotation.MyAnnotationSex.sex;

public class MyAnnotationTest {
	@MyAnnotationName(setName="张三")
	private String name;
	
	public sex sex;
	
	public String getName() {
		return name;
	}

	public sex getSex() {
		return sex;
	}

	public void setName(String name) {
		this.name = name;
	}

	@MyAnnotationSex(sex=annotation.MyAnnotationSex.sex.MAN)
	public void setSex(sex sex) {
		this.sex = sex;
	}

	public static void main(String[] args) {
		MyAnnotationTest test=new MyAnnotationTest();
		System.out.println(test.name);
		System.out.println(test.sex);
	}
}
