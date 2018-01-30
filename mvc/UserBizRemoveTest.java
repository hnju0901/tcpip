package mvc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserBizRemoveTest {

	@Test
	void testRemove() {
		UserBiz biz = new UserBiz();
		String userId = "id04";
		try {
			biz.remove(userId);
		} catch (Exception e) {
			System.out.println("삭제 오류");
			e.printStackTrace();
		}
	}

}
