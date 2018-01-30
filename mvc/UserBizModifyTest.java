package mvc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserBizModifyTest {

	@Test
	void testModify() {
		UserBiz biz = new UserBiz();
		UserVO user = new UserVO("id04", "pwd04", "name04");
		try {
			biz.modify(user);
		} catch (Exception e) {
			System.out.println("수정 오류");
		}
	}

}
