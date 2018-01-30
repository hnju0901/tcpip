package com.user.test;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.UserVO;

class UserBizRegisterTest {

	@Test
	void testRegisterUserVO() {
		UserBiz biz = new UserBiz();
		UserVO user =new UserVO("id00", "pwd", "¿Ã∏ß");  
		try {
			biz.register(user);
			System.out.println("Insert Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
