package user.test;

import org.junit.jupiter.api.Test;

import user.UserBiz;

class UserBizRemoveTest {

	@Test
	void testRemoveString() {
		UserBiz biz = new UserBiz();
		String id = "�ϳ�";
		try {
			biz.remove(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
