package mvc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserBizRegisterTest {

	@Test
	void testRegister() {
		UserBiz biz = new UserBiz();
		
		UserVO user2= new UserVO("id07", "pwd07", "name07");
		UserVO user= new UserVO("id08", "pwd08", "name08");

		
		try {
			biz.register(user);
			biz.register(user2);
		} catch (Exception e) {
			System.out.println("�Է� ����");
			e.printStackTrace();//exception�� ��� ��Ȳ����
		}
	}

}
