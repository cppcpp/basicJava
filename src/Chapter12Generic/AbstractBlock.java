package Chapter12Generic;

public abstract class AbstractBlock {
	public abstract void body() throws Exception;
	
	
	public Thread toThread(){
		return new Thread(){
			public void run()
			{
				try{
					body();
				}catch(Throwable t){
					AbstractBlock.<RuntimeException>throwAs(t);
				}
			}
		};
	}
	
	public static <T extends Throwable> void throwAs(Throwable e) throws T
	{
		throw (T)e;
	}
}
