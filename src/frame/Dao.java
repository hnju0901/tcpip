package frame;

import java.util.ArrayList;

public interface Dao {
	//CRUD Method Define
	/**
	 * Insert Object to Oracle DB
	 * */
	public void insert(Object obj);
	public void delete(Object obj);
	public void update(Object obj);
	public Object select(Object obj);
	public ArrayList<Object> select();
	//프로그램의 스펙 spec, frame
}
