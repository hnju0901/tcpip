package mvc;

public class UserBiz {
	private UserDao dao;
	public UserBiz() {
		dao = new UserDao();
		//tight하기 때문
	}
	public void register(UserDTO user) {
		//포인트주거나 id check하거나
		System.out.println("데이터 체크");
		System.out.println("아이템 입력");
		dao.userInsert(user);
		System.out.println("메일 전송");
	}//한번에 진행되어야함
	public void modify(UserDTO user) {
		System.out.println("데이터 체크");
		dao.userUpdate(user);
	}
	public void remove(String id) {
		System.out.println("데이터 체크");
		dao.userDelete(id);
	}
}
