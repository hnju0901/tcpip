package com.user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.UserVO;

class UserBizModifyTest {

	@Test
	void testModifyUserVO() {
		UserBiz biz = new UserBiz();
		UserVO user =new UserVO("id01", "¸Þ·Õ", "ÇÏ³ªÀÌ");  
		try {
			biz.modify(user);;
			System.out.println("Update Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
