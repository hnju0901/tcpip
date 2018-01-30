/**
 * 
 */
package user;

import java.util.ArrayList;

import frame.Dao;
import vo.UserVO;

/**
 * @author student
 *
 */
public class UserDAO implements Dao {

	
	@Override
	public void insert(Object obj) {
		UserVO user = (UserVO)obj;
		System.out.println(user+" Inserted ...");
	}

	@Override
	public void delete(Object obj) {
		String id = (String)obj;
		System.out.println(id+" Deleted ...");
	}

	
	@Override
	public void update(Object obj) {
		UserVO user = (UserVO)obj;
		System.out.println(user+" Updeted ...");
	}

	@Override
	public Object select(Object obj) {
		String id = (String)obj;
		System.out.println(id+" Selected ...");
		UserVO user = new UserVO(id, "pwd", "name");
		return user;
	}

	
	@Override
	public ArrayList<Object> select() {
		ArrayList<Object> list = new ArrayList<>();
		System.out.println("Selected All...");
		list.add(new UserVO("id01", "pwd01", "name01"));
		list.add(new UserVO("id02", "pwd02", "name02"));
		list.add(new UserVO("id03", "pwd03", "name03"));
		list.add(new UserVO("id04", "pwd04", "name04"));
		list.add(new UserVO("id05", "pwd05", "name05"));
		return list;
	}

}
