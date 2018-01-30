package com.user.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.Item;
import com.vo.User;

class UserBizRegisterTest {

	@Test
	void testRegister() {
	  Biz<User,String> biz = new UserBiz();
	  ArrayList<Item> list = new ArrayList<>();
	  User user = new User("id", "pwd", "name");
	try {
		biz.register(user);
		System.out.println("입력성공");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
