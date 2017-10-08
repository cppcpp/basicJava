package Collection.Generator;

public class Letters implements Generator<Pair<Integer, String>>{
	private int letter='A';
	private int number=1;
	@Override
	public Pair<Integer, String> next() {
		// TODO Auto-generated method stub
		return new Pair<Integer, String>(number++, ""+letter++);
	}
	
}
