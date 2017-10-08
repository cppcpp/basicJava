package Collection;

public class ImplementClass implements AbstractInterface{

	public int add(int a,int b) {
		// TODO Auto-generated method stub
			return a+b;
	}

	@Override
	public int add(int a, int b, int c) {
		// TODO Auto-generated method stub
		return a+b+c;
	}
	public static void main(String[] args) {
		Interface interface1=new ImplementClass();
	}
}
