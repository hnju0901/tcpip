package com.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.vo.Item;
import com.vo.User;

public class UserBiz extends Biz<User, String> {

	UserDao dao;

	public UserBiz() {
		dao = new UserDao();
	}

	@Override
	public void register(User o) throws Exception {
		Connection conn = getConnection();
		try {
			// User 정보를 입력
			dao.insert(o, conn);
			// User가 보유하고 있는 Item 정보 입력
			dao.insertItem(o, conn);
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
		// UserId 정보 입력
		Connection conn = getConnection();
		try {
			// UserId에 해당하는 UserItems 정보 삭제.??
			// UserId에 해당하는 User정보 삭제.
			dao.delete(i, conn);
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
	}

	@Override
	public void modify(User o) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User get(String i) throws Exception {
		// Userid에 해당하는 user정보 가져옴
		// 입력한 ID로 User정보 조회
		// 입력한 ID로 UserItem정보 조회
		// Item의 정보를 User에게 Setting
		// User 정보를 리턴
		Connection conn = getConnection();
		User user = null;
		ArrayList<Item> items = null;
		try {
			// UserId에 해당하는 UserItems 정보 삭제.??
			// UserId에 해당하는 User정보 삭제.
			user = dao.select(i, conn);
			items = dao.selectItem(i, conn);
			user.setItems(items);
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		// userid에 해당하는 itemid가져옴
		return user;
	}

	@Override
	public ArrayList<User> get() throws Exception {

		Connection conn = getConnection();
		ArrayList<User> list = null;
		ArrayList<Item> items = null;
		try {
			// 모든 User정보 조회
			list = dao.select(conn);
			
			for (User user : list) {
				// 각 user ID의 UserItem정보 조회
				items = dao.selectItem(user.getId(), conn);
				// Item의 정보를 User에게 Setting
				user.setItems(items);
			}
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		// ArrayList User 정보를 리턴
		return list;
	}
}