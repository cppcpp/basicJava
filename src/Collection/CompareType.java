package Collection;

import java.util.Random;


import Collection.Generator.Generator;

//比较，，实现compareTo方法
public class CompareType implements Comparable<CompareType>{
	private int i;
	private int j;
	private static int count=1;
	
	public CompareType(int i,int j){
		this.i=i;
		this.j=j;
	}
	public String toSting(){
		String result="[i="+i+",j="+j+"]";
		if(count++%3==0)
			result+="\n";
		return result;
	}
	public int compareTo(CompareType o) {
		return (i<o.i?-1:(i==o.i?0:1));
	}
	
	//生成器
	private static Random random=new Random(47);
	public static Generator<CompareType> generator(){
		return new Generator<CompareType>() {
			@Override
			public CompareType next() {
				return new CompareType(random.nextInt(100),random.nextInt(100));
			}
		};
		
	}
	
	private void mian() {
		//CompareType[] a=Genera;
	}
}
