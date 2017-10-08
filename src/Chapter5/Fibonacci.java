package Chapter5;

import java.util.Scanner;

public class Fibonacci {
public static void main(String[] args) {
	final int M=10007;
	Scanner in=new Scanner(System.in);
	int i=in.nextInt();
	//1
	int f1=1;
	int f2=1;
	int s=0;
	//f3=f2+f1,f4=f3+f2,,,Çófn
	for(int j=3;j<=i;j++){
		s=f1+f2;
		f1=f2;
		f2=s;
	}
	System.out.println("1:"+s+"%"+M+"=="+s%M);
	
	//2.
	int g1=1;
	int g2=1;
	int t=0;
	for(int j=3;j<=i;j++){
		t=(g1%M+g2%M)%M;
		g1=g2; 
		g2=t;
	}
	System.out.println("2:"+s+"%"+M+"=="+t);

	//3.µÝ¹é£¬Ð§ÂÊ²î
	int r=F(i);
	System.out.println("3:"+r+"%"+M+"=="+r%10007);
}
	public static int F(int n){
		if(n<=2)
			return 1;
		else{
			return F(n-1)+F(n-2);
		}
	}

}
