package frame;

import java.util.ArrayList;

public abstract class Biz <T,V>{
	protected Dao<T,V> dao;
	
	public void start() {
		System.out.println("Biz 시작합니다~");
	}
	public void end() {
		System.out.println("Biz 끝났습니다~");
	}

	public abstract void register(T t) throws Exception;

	public abstract void remove(V v)throws Exception;

	public abstract void modify(T t)throws Exception;

	public abstract T get(V v)throws Exception;

	public abstract ArrayList<T> get()throws Exception;

}
