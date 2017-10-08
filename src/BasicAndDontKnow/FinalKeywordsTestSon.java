package BasicAndDontKnow;

import java.lang.annotation.Annotation;

public class FinalKeywordsTestSon extends FinalKeywordsTest{
	public FinalKeywordsTestSon(){
		System.out.println("son constractor");
	}
	
	@Override
	public  void a(){
		System.out.println("b方法");
	}
	public static void main(String[] args) {
		//FinalKeywordsTest test=new FinalKeywordsTest();
		FinalKeywordsTest testSon=new FinalKeywordsTest();
		testSon.a();
	}
}
