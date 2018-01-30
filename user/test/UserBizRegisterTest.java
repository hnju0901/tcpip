package user.test;

import org.junit.jupiter.api.Test;

import user.UserBiz;
import vo.User;

class UserBizRegisterTest {

	@Test
	void testRegisterUser() {
		UserBiz biz = new UserBiz();
		User user = new User("ÇÏ³ª1", "pwd", "name", 4);
		try {
			biz.register(user);
			System.out.println(user);
			System.out.println(user.getItem());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
