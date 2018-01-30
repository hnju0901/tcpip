package com.user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.UserVO;

class UserBizRemoveTest {

	@Test
	void testRemoveString() {
		UserBiz biz = new UserBiz();
		String i = "id00";
		try {
			biz.remove(i);;
			System.out.println("Insert Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
