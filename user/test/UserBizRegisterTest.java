package user.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frame.Biz;
import user.UserBiz;
import vo.UserVO;

class UserBizRegisterTest {

	Biz<UserVO, String> biz;
	
	public UserBizRegisterTest() {
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
	void testRegisterUserVO() {
		UserVO user = new UserVO("id01", "pwd", "name");
		try {
			biz.register(user);
		} catch (Exception e) {
			System.out.println("에러코드:"+e.getMessage());
			System.out.println("ID가 중복 되었습니다.");
		}		
	}

}
