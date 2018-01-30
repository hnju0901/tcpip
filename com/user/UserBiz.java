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
			// User ������ �Է�
			dao.insert(o, conn);
			// User�� �����ϰ� �ִ� Item ���� �Է�
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
		// UserId ���� �Է�
		Connection conn = getConnection();
		try {
			// UserId�� �ش��ϴ� UserItems ���� ����.??
			// UserId�� �ش��ϴ� User���� ����.
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
		// Userid�� �ش��ϴ� user���� ������
		// �Է��� ID�� User���� ��ȸ
		// �Է��� ID�� UserItem���� ��ȸ
		// Item�� ������ User���� Setting
		// User ������ ����
		Connection conn = getConnection();
		User user = null;
		ArrayList<Item> items = null;
		try {
			// UserId�� �ش��ϴ� UserItems ���� ����.??
			// UserId�� �ش��ϴ� User���� ����.
			user = dao.select(i, conn);
			items = dao.selectItem(i, conn);
			user.setItems(items);
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		// userid�� �ش��ϴ� itemid������
		return user;
	}

	@Override
	public ArrayList<User> get() throws Exception {

		Connection conn = getConnection();
		ArrayList<User> list = null;
		ArrayList<Item> items = null;
		try {
			// ��� User���� ��ȸ
			list = dao.select(conn);
			
			for (User user : list) {
				// �� user ID�� UserItem���� ��ȸ
				items = dao.selectItem(user.getId(), conn);
				// Item�� ������ User���� Setting
				user.setItems(items);
			}
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		// ArrayList User ������ ����
		return list;
	}
}