package com.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.item.ItemDao;
import com.item.UserItemDao;
import com.vo.Item;
import com.vo.User;

public class UserBiz extends Biz<User, String> {
	ItemDao idao;
	Item item;
	UserItemDao uidao;
	public UserBiz() {
		dao = new UserDao();
		idao = new ItemDao();  
		item = new Item();
		uidao= new UserItemDao();
	}

	@Override
	public void register(User o) throws Exception {
		Connection conn = getConnection();
		try {
			dao.insert(o, conn);
			// 1. 유저의 grade를 가져와서 2. 그 grade를 ItemDAO에 넣어준다 (selectItem에) 
			// 3. 그럼 아이템이 먼지 알랴줌 4. 알아낸 아이템을 변수 item에 넣어줌 ㅎ 
			item= idao.selectItem(o.getGrade(),conn); 
			// 1. item을 User에 넣어줌 ㅎ (setItem을 이용해서 ㅎ) 
			o.setItem(item);	
			uidao.insert(o, conn);
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
			dao.update(o, conn);
			item= idao.selectItem(o.getGrade(),conn);
			o.setItem(item);
			uidao.update(o, conn);
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
			uidao.delete(i, conn);
			dao.delete(i, conn);
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
		User user=null;
		try {
			user= dao.select(i, conn);
			item= idao.selectItem(user.getGrade(),conn);
			user.setItem(item);
			System.out.println(user);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		return user;
	}

	@Override
	public ArrayList<User> get() throws Exception {
		Connection conn = getConnection();
		ArrayList<User> list = null;
		ArrayList<User> listResult = new ArrayList<>();
		
		try {
			list= dao.select(conn);
			for(User user : list) {
				item= idao.selectItem(user.getGrade(),conn);
				user.setItem(item);
				
				listResult.add(user);
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		return listResult;
	}

}
