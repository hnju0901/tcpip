package user;

import java.util.ArrayList;

import frame.Biz;
import vo.UserVO;

public class UserBiz extends Biz<UserVO, String> {

	public UserBiz() {
		dao= new UserDao();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void register(UserVO t) throws Exception {
		start();
		try {
			dao.insert(t);
		} catch (Exception e) {
			System.out.println("예외발생");
			throw e;
		}
		end();
	}

	@Override
	public void remove(String v) throws Exception {
		start();
		try {
			dao.delete(v);
		} catch (Exception e) {
			System.out.println("예외발생");
			throw e;
		}
		end();
	}

	@Override
	public void modify(UserVO t) throws Exception {
		start();
		try {
			dao.update(t);
		} catch (Exception e) {
			System.out.println("예외발생");
			throw e;
		}
		end();
		
	}

	@Override
	public UserVO get(String v) {
		start();
		UserVO user = null;
		try {
			user=dao.select(v);
		} catch (Exception e) {
			System.out.println("예외발생");
		}
		end();
		return user;
	}

	@Override
	public ArrayList<UserVO> get() {
		start();
		 ArrayList<UserVO> list = null;
		 try {
			list= dao.select();
		} catch (Exception e) {
			System.out.println("예외발생");
		}
		 end();
		return list;
	}

}
