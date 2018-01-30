package com.test;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.User;

class UserBizModifyTest {

	@Test
	void testModifyUser() {
		User user = new User("±¤¼®", "pwd", "¸Þ·Õ", 2);
		UserBiz biz = new UserBiz();
		try {
			biz.modify(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

}
