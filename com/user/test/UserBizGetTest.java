package com.user.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.Item;
import com.vo.User;

class UserBizGetTest {

	@Test
	void testGetString() {
		UserBiz biz = new UserBiz();
		String userId = "ID01";
		User user = null;
		try {
			user = biz.get(userId);
			System.out.println("================개별조회 ================");
			System.out.println(user);
			for (Item item : user.getItems()) {
				System.out.println(item);
			}
			System.out.println("========================================");
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
			System.out.println("================전체조회 ================");
			for (User user : list) {
				System.out.println(user);
				for (Item item : user.getItems()) {
					System.out.println(item);
				}
			}
			System.out.println("========================================");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
