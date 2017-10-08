package Collection.Generator;

import java.util.ArrayList;
/*
 * 适配器模式
 * 
 * 
 * */
public class CollectionData<T> extends ArrayList<T>{
	
	public CollectionData(Generator<T> generator,int quantity){
		for(int i=0;i<quantity;i++){
			add(generator.next());
		}
	}
	
	public CollectionData<T> list(Generator<T> generator,int quantity){
		return new CollectionData<>(generator, quantity);
	}
	
}
