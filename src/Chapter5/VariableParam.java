package Chapter5;

public class VariableParam {
	//参数数量可变
	public static double max(double...values){
		double largest=Double.MIN_VALUE;
		for(double v:values){
			if(v>largest){
				largest=v;
			}
		}
		return largest;
	}
	
	public static void main(String[] args) {
		double max=max(1.23,1.345,3.544);
		System.out.println("The max number is:"+max);
	}
}

