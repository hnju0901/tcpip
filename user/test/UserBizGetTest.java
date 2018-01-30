package user.test;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frame.Biz;
import user.UserBiz;
import vo.UserVO;

class UserBizGetTest {

	Biz<UserVO, String> biz;

	public UserBizGetTest() {
		biz = new UserBiz();
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("TEST START");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("TEST END");
	}

	@Test
	void testGetString() {
		UserVO user=null;
		try {
			user = biz.get("id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user);
	}

	@Test
	void testGet() {
		ArrayList<UserVO> list=new ArrayList<>();
		try {
			list = biz.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(UserVO vo:list) {
			System.out.println(vo);
		}
	}

}
