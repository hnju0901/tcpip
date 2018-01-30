package user;

import java.sql.Connection;
import java.util.ArrayList;

import frame.Biz;
import item.ItemDao;
import vo.Item;
import vo.User;


public class UserBiz extends Biz<User, String> {
	ItemDao itemDao;
	Item item;
	UserDao userDao;
	public UserBiz() {
		userDao = new UserDao();
		itemDao = new ItemDao();  
		item = new Item();
	}

	@Override
	public void register(User o) throws Exception {
		Connection conn = getConnection();
		try {
			userDao.insert(o, conn);
			// 1. 유저의 grade를 가져와서 2. 그 grade를 ItemDAO에 넣어준다 (selectItem에) 
			// 3. 그럼 아이템이 먼지 알랴줌 4. 알아낸 아이템을 변수 item에 넣어줌 ㅎ 
			item= itemDao.selectItem(o.getGrade(),conn); 
			// 1. item을 User에 넣어줌 ㅎ (setItem을 이용해서 ㅎ) 
			o.setItem(item);
			o.setItemCount(1);
			userDao.insertUserItem(o, conn);
			conn.commit();
			
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}
	
	@Override
	public void modify(User o) throws Exception {
		Connection conn = getConnection();
		try {
			userDao.update(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	@Override
	public void remove(String i) throws Exception {
		Connection conn = getConnection();
		try {
			userDao.deleteUserItem(i, conn);
			userDao.delete(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	@Override
	public User get(String i) throws Exception {
		Connection conn = getConnection();
		User user=new User();
		try {
			//- 사용자의 ID를 입력 받는다.
			//- 사용자 정보를 조회한다.
			user= userDao.select(i, conn);
			
			//- 사용자 ID로 ITEM ID와 COUNT를 조회 한다.
			//- 사용자의 COUNT를 setting한다.
			user= userDao.setItem(user, conn);
			//- 사용자 ITEM을 조회한다.
			Item item = itemDao.select(user.getItem().getId(), conn);
			//- 사용자에 ITEM을 Setting 한다.
			user.setItem(item);
		} catch (Exception e) {	
			throw e;
		} finally {
			close(conn);
		}
		return user;
	}

	@Override
	public ArrayList<User> get() throws Exception {
		Connection conn = getConnection();
		ArrayList<User> list = new ArrayList<>();
		
		try {
			//- 모든 사용자 정보를 조회 한다.
			//- 각 사용자의 ID이용하여 UserItem 정보 조회
			//- 사용자 정보에 Item을 setting
			//- 사용자를 arraylist에 add
			list= userDao.select(conn);
			System.out.println(list.size());
			for(User user : list) {
				//list의 user 1개 꺼내서 item(only item_id), count setting
				user= userDao.setItem(user, conn);	
				item = itemDao.select(user.getItem().getId(), conn);
				user.setItem(item);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			close(conn);
		}
		return list;
	}

	/*public Item Itemget(int i) throws Exception {
		Connection conn = getConnection();
		Item item=null;
		try {
			itemDao.select(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		return item;
	}*/

}
