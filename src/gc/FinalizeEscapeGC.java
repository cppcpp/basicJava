package gc;

/*
 * 两次自救，第二次失败，因为每个对象的finalize方法只有机会执行一次
 * 
 * 尽量避免使用finalize方法
 * */
public class FinalizeEscapeGC {
	private static FinalizeEscapeGC SAVE_HOOK=null;
	public void isAlive(){
		System.out.println("yes,I am still alive");
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize method execute");
		FinalizeEscapeGC.SAVE_HOOK=this;
	}
	
	public static void main(String[] args) {
		SAVE_HOOK=new FinalizeEscapeGC();
		
		
		
		//1.成功自救
		SAVE_HOOK=null;
		System.gc();
		
		//finalize方法优先级很低，暂停一会等等他
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead");
		}
		
		
		
		
		//和上面代码一样，，这次自救失败
		SAVE_HOOK=null;
		System.gc();
		
		//finalize方法优先级很低，暂停一会等等他
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(SAVE_HOOK!=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead");
		}
	}
	
}
