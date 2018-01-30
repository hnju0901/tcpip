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
			// 1. ������ grade�� �����ͼ� 2. �� grade�� ItemDAO�� �־��ش� (selectItem��) 
			// 3. �׷� �������� ���� �˷��� 4. �˾Ƴ� �������� ���� item�� �־��� �� 
			item= itemDao.selectItem(o.getGrade(),conn); 
			// 1. item�� User�� �־��� �� (setItem�� �̿��ؼ� ��) 
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
			//- ������� ID�� �Է� �޴´�.
			//- ����� ������ ��ȸ�Ѵ�.
			user= userDao.select(i, conn);
			
			//- ����� ID�� ITEM ID�� COUNT�� ��ȸ �Ѵ�.
			//- ������� COUNT�� setting�Ѵ�.
			user= userDao.setItem(user, conn);
			//- ����� ITEM�� ��ȸ�Ѵ�.
			Item item = itemDao.select(user.getItem().getId(), conn);
			//- ����ڿ� ITEM�� Setting �Ѵ�.
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
			//- ��� ����� ������ ��ȸ �Ѵ�.
			//- �� ������� ID�̿��Ͽ� UserItem ���� ��ȸ
			//- ����� ������ Item�� setting
			//- ����ڸ� arraylist�� add
			list= userDao.select(conn);
			System.out.println(list.size());
			for(User user : list) {
				//list�� user 1�� ������ item(only item_id), count setting
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
