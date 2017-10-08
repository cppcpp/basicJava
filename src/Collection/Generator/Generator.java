package Collection.Generator;

/*
 * 泛型类的生成器接口
 * Generator生成器是工厂模式的一个实现
 * */
public interface Generator<T> {
	public T next();
}
