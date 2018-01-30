package frame;

import java.util.ArrayList;

public abstract class Dao<T, V> {
	public void start() {
		System.out.println("Dao �����մϴ�~...");
	}
	public void end() {
		System.out.println("Dao �������ϴ�~...");
	}

	public abstract void insert(T t) throws Exception;

	public abstract void delete(V v) throws Exception;

	public abstract void update(T t) throws Exception;

	public abstract T select(V v) throws Exception;

	public abstract ArrayList<T> select() throws Exception;

}
