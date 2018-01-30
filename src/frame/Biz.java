package frame;

import java.util.ArrayList;

public abstract class Biz {
	protected Dao dao;
	public void start() {
		System.out.println("Start...");
	}
	public void end() {
		System.out.println("End...");
	}
	public abstract void register(Object obj);
	public abstract void modify(Object obj);
	public abstract void remove(Object obj);
	public abstract Object get(Object obj);
	public abstract ArrayList<Object> get();
	//필요하면 추상클래스 안에는 함수도 들어갈 수 있다.
}
