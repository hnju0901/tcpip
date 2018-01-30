package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Item;
import com.vo.User;

public class UserDao extends Dao<User, String> {

	public ArrayList<Item> selectItem(String i, Connection conn) throws Exception {
		// UserId를 넣으면 해당 id의 item list를 가져온다.
		
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<Item> items = new ArrayList<>();
		Item item = null;
		try {
			st = conn.prepareStatement(Sql.selectItem);
			st.setString(1, i);
			rs = st.executeQuery();
			while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			item = new Item(id, name, price);
			items.add(item);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
			close(rs);
		}
		return items;
	}

	// User가 Item list정보 갖고 있음.//
	// 이 Items 정보를 USERITEM 정보에 넣는 과정//
	public void insertItem(User o, Connection conn) throws Exception {
		ArrayList<Item> items = o.getItems();
		String id = o.getId();
		PreparedStatement st = null;
		try {
			for (Item item : items) {
				st = conn.prepareStatement(Sql.insertUserItem);
				st.setString(1, id);
				st.setInt(2, item.getId());
				st.executeUpdate();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public void insert(User o, Connection conn) throws Exception {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(Sql.insertUser);
			st.setString(1, o.getId());
			st.setString(2, o.getName());
			st.setString(3, o.getPwd());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public void delete(String i, Connection conn) throws Exception {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(Sql.deleteUser);
			st.setString(1, i);
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}

	}

	@Override
	public void update(User o, Connection conn) throws Exception {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(Sql.updateUser);
			st.setString(1, o.getName());
			st.setString(2, o.getPwd());
			st.setString(3, o.getId());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public User select(String i, Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		User user = null;
		try {
			st = conn.prepareStatement(Sql.selectUser);
			st.setString(1, i);
			rs = st.executeQuery();
			rs.next();
			String userId = rs.getString("ID");
			String userPwd = rs.getString("PWD");
			String userName = rs.getString("NAME");
			user = new User(userId, userPwd, userName);
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
			close(rs);
		}
		return user;
	}

	@Override
	public ArrayList<User> select(Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<>();
		User user = null;
		try {
			st = conn.prepareStatement(Sql.selectAllUser);
			rs = st.executeQuery();
			while (rs.next()) {
				String userId = rs.getString("ID");
				String userPwd = rs.getString("PWD");
				String userName = rs.getString("NAME");
				user = new User(userId, userPwd, userName);
				list.add(user);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
			close(rs);
		}
		return list;
	}

}
