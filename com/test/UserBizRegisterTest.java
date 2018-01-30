package com.test;

import org.junit.jupiter.api.Test;

import com.frame.Dao;
import com.user.UserBiz;
import com.vo.User;

class UserBizRegisterTest {

	@Test
	void testRegisterUser() {
		UserBiz biz = new UserBiz();
		
		User user = new User("±¤¼®", "pwd", "name", 4);
		try {
			biz.register(user);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
