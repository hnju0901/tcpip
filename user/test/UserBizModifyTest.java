package user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frame.Biz;
import user.UserBiz;
import vo.UserVO;

class UserBizModifyTest {
	
	Biz<UserVO, String> biz;
	
	public UserBizModifyTest() {
		biz= new UserBiz();
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
	void testModifyUserVO() {
		UserVO user = new UserVO("id01", "pwd", "name");
		try {
			biz.modify(user);
		} catch (Exception e) {
			System.out.println("�����ڵ�:"+e.getMessage());
			System.out.println("�ش� ID�� �����ϴ�.");
		}
	}

}
