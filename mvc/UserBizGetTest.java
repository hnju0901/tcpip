package mvc;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserBizGetTest {

	@Test
	void testGet() {
		UserBiz biz =new UserBiz();
		UserVO user = null;
		String userId = "id01";
		try {
			user= biz.get(userId);
			System.out.println(user);
		} catch (Exception e) {
		System.out.println("ID : "+userId+"선택 오류");
		e.printStackTrace();
		}
	}

	@Test
	void testGetAll() {
		UserBiz biz =new UserBiz();
		ArrayList<UserVO> list = null; 
		System.out.println("-----------------------------------------");
		try {
			list = biz.get();
			for(UserVO user: list) {
				System.out.println(user);
			}
		} catch (Exception e) {
			System.out.println("모두선택 오류");
			e.printStackTrace();
		}
		System.out.println("-----------------------------------------");	
	}

}
