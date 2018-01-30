package user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frame.Biz;
import user.UserBiz;
import vo.UserVO;

class UserBizRemoveTest {
	
	Biz<UserVO, String> biz;

	public UserBizRemoveTest() {
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
	void testRemoveString() {
		try {
			biz.remove("id01");
		} catch (Exception e) {
			System.out.println("에러코드:"+e.getMessage());
			System.out.println("해당 ID가 없습니다.");
		}
	}

}
