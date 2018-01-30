package com.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.User;

class UserBizGetTest {

	@Test
	void testGetString() {
		String id = "id01";
			UserBiz biz = new UserBiz();
			try {
				biz.get(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	@Test
	void testGet() {
		UserBiz biz = new UserBiz();
		ArrayList<User> listResult = null;
		try {
			listResult= biz.get();
			for(User user : listResult) {
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
