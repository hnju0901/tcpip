package user;

import java.util.ArrayList;

import frame.Dao;
import vo.UserVO;

public class UserDao extends Dao<UserVO, String> {

	@Override
	public void insert(UserVO t) throws Exception{
		start();
		if(t.getId().equals("id01")) {
			throw new Exception("1");
		}
		System.out.println(t+" Inserted...");
		end();
	}

	@Override
	public void delete(String v) throws Exception{
		start();
		if(v.equals("id01")) {
			throw new Exception("2");
		}		
		System.out.println(v+" deleted...");
		end();
	}

	@Override
	public void update(UserVO t) throws Exception{
		start();
		if(t.getId().equals("id01")) {
			throw new Exception("3");
		}
		System.out.println(t+" Updated...");
		end();
	}

	@Override
	public UserVO select(String v) throws Exception{
		start();
			
		System.out.println(v+" Selected...");
		UserVO user = new UserVO("id01", "pwd01", "name01");
		end();
		return user;
	}

	@Override
	public ArrayList<UserVO> select() throws Exception{
		start();
		System.out.println("Selected All...");
		
		ArrayList<UserVO> list = new ArrayList<>();
		list.add(new UserVO("id02", "pwd02", "name02"));
		list.add(new UserVO("id04", "pwd04", "name04"));
		list.add(new UserVO("id06", "pwd06", "name06"));
		list.add(new UserVO("id08", "pwd08", "name08"));
		list.add(new UserVO("id10", "pwd10", "name10"));
		end();
		return list;
	}

}
