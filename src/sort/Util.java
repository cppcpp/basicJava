package sort;


public class Util {
	Object i,j;
	public Util(Object i,Object j){
		this.i=i;
		this.j=j;
		swap();
	}
	public void swap(){
		Object temp=this.i;
		this.i=this.j;
		this.j=temp;
	}
}
