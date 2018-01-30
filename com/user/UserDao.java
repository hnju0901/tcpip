package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.User;

public class UserDao extends Dao<User, String> {

	@Override
	public void insert(User o, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result = 0;
		try {
			st = conn.prepareStatement(Sql.insertUser);
			st.setString(1, o.getId());
			st.setString(2, o.getPwd());
			st.setString(3, o.getName());
			st.setInt(4, o.getGrade());
			result = st.executeUpdate();
			if (result == 1)
				System.out.println(result + "건 userDao 입력 완료");
			else if (result == 0)
				System.out.println("userDao 입력 실패");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public void update(User o, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.updateUser);

			st.setString(1, o.getPwd());
			st.setString(2, o.getName());
			st.setInt(3, o.getGrade());
			st.setString(4, o.getId());
			result = st.executeUpdate();
			if (result == 1) {
				System.out.println(result + "건 userDao 수정 완료");
			} else if (result == 0) {
				System.out.println("userDao 수정 실패");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}
	@Override
	public void delete(String i, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.deleteUser);
			st.setString(1, i);
			result = st.executeUpdate();
			if (result == 1)
				System.out.println(result + "건 userDao 삭제 완료");
			else if (result == 0)
				System.out.println("userDao 삭제 실패");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}

	@Override
	public User select(String i, Connection conn) throws Exception {
		PreparedStatement st = null;
		User user = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(Sql.selectUser);
			st.setString(1, i);
			rs = st.executeQuery();
			rs.next();
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			int grade = rs.getInt("grade");
			user = new User(id, pwd, name, grade);
			System.out.println("userDao 선택 완료");
		} catch (Exception e) {
			System.out.println("userDao 선택 실패");
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
		ArrayList<User> list = new ArrayList<>();
		User user = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(Sql.selectAllUser);
			rs = st.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				int grade = rs.getInt("grade");
				user = new User(id, pwd, name, grade);
				list.add(user);
			}
			System.out.println("userDao 모두 선택 완료");
		} catch (Exception e) {
			System.out.println("userDao 모두 선택 실패");
			throw e;
		} finally {
			close(st);
			close(rs);
		}
		return list;
	}

}
