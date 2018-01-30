package user;

import java.util.ArrayList;

import frame.Biz;
import frame.Dao;

public class UserBIZ extends Biz {

	public UserBIZ() {
		
		dao = new UserDAO();
		
	}
	
	@Override
	public void register(Object obj) {
		start();
		dao.insert(obj);
		end();
	}

	@Override
	public void modify(Object obj) {
		start();
		dao.update(obj);
		end();

	}

	@Override
	public void remove(Object obj) {
		start();
		dao.delete(obj);
		end();
	}

	@Override
	public Object get(Object obj) {
		start();
		end();
		return dao.select(obj);
	}

	@Override
	public ArrayList<Object> get() {
		start();
		end();
		return dao.select();
	}

}
