package user.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import user.UserBiz;
import vo.User;

class UserBizGetTest {

	@Test
	void testGetString() {
		User user = new User();
		UserBiz biz = new UserBiz();
		String id = "ÇÏ³ª";
		try {
			user =biz.get(id);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	void testGet() {
		
		UserBiz biz = new UserBiz();
		ArrayList<User> list = null;
		try {
			list = biz.get();
			for(User user: list) {
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
