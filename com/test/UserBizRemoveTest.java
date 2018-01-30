package com.test;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;

class UserBizRemoveTest {

	@Test
	void testRemoveString() {
		String id = "±¤¼®";
		UserBiz biz = new UserBiz();
		try {
			biz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
