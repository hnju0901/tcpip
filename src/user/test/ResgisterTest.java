package user.test;

import frame.Biz;
import user.UserBIZ;
import vo.UserVO;

public class ResgisterTest {

	public static void main(String[] args) {
		Biz biz = new UserBIZ();
		UserVO user = new UserVO("id", "pwd", "name00");
		biz.register(user);
		biz.modify(user);
		biz.remove(user.getId());
		biz.get(user.getId());
		biz.get();
	}

}
