package Collection.Generator;

public class Government implements Generator<String>{
	String[] foundation=("strange women laying in ponds no basic for a system for government").split(" ");
	private int index;
	
	public String next() {
		if(index>foundation.length)
			throw new ArrayIndexOutOfBoundsException();
		return foundation[index++];
	}

}
