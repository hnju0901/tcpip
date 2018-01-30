package com.user.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.UserVO;

class UserBizGetTest {

	@Test
	void testGetString() {
		UserBiz biz = new UserBiz();
		UserVO user = null;
		String i = "id01";
		try {
			user= biz.get(i);
			System.out.println("���� ���� : "+user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Test
	void testGet() {
		UserBiz biz = new UserBiz();
		ArrayList<UserVO> list = null;
		try {
			list= biz.get();
			System.out.println("=========================��� ����=========================");
			for(UserVO user: list) {
				System.out.println(user);
			}
			System.out.println("===========================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
