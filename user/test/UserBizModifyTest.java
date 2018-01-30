package user.test;

import org.junit.jupiter.api.Test;

import user.UserBiz;
import vo.User;

class UserBizModifyTest {

	@Test
	void testModifyUser() {
		UserBiz biz = new UserBiz();
		User user = new User("ÇÏ³ª", "pwd", "^^^");
		try {
			biz.modify(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
