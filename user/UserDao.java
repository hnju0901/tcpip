//database�� �ʹ� ���� �ǵ帰��.//
//��ü���⸸ ���󰡴ٰ� relationship�� �ִ� database�� �ǵ帮�� ��ƴ�.//
//���� join�� �Ἥ ��ü����� Ÿ���� ��. //
//RDDMS (ORACLE, MYSQL->MARIADB:Open source)�� SQL���� �̿���.//
//open source�� �����ͼ� �����ؼ� product���� consulting �ؼ� ������//
//NO-SQL -> ���� DB//instance method�̿� �� ���� �̿�// 
//�����̶� �׷��������� sql�� �̿�//
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Item;
import vo.User;

public class UserDao extends Dao<User, String> {
	
	public User setItem(User user, Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		Item item = new Item();
		try {
			// UserID�� �ش��ϴ� UserItem ����(User_id, item_id, count)
			st = conn.prepareStatement(Sql.selectUserItem);
			st.setString(1, user.getId());
			rs = st.executeQuery();
			rs.next();

			// item_id�� ���� ���� item�� �־��ִ� �ž�
			int itemId = rs.getInt("itemid");
			item.setId(itemId);
			// item�� user�� �־��ذž�
			user.setItem(item);

			// count�� user�� �־��ذž�
			int count = rs.getInt("count");
			user.setItemCount(count);
			
		} catch (Exception e) {
			System.out.println("userDao ���� ����");
			throw e;
		} finally {
			close(st);
			close(rs);
		}
		return user;
	}

	public void deleteUserItem(String i, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.deleteUserItem);
			st.setString(1, i);
			result = st.executeUpdate();
			if (result == 1)
				System.out.println(result + "�� userItemDao ���� �Ϸ�");
			else if (result == 0)
				System.out.println(result + "�� userItemDao ���� ����");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}

	public void insertUserItem(User o, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.insertUserItem);
			st.setString(1, o.getId());
			st.setInt(2, o.getItem().getId());
			st.setInt(3, o.getItemCount());
			result = st.executeUpdate();
			if (result == 1)
				System.out.println(result + "�� userItemDao �Է� �Ϸ�");
			else if (result == 0)
				System.out.println(result + "�� userItemDao �Է� ����");
		} catch (Exception e) {
			throw e;
		} finally {
			close(st);
		}
	}
/////////////////////////////////////////////////////////////////////////////////
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
				System.out.println(result + "�� userDao �Է� �Ϸ�");
			else if (result == 0)
				System.out.println("userDao �Է� ����");
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
			st.setString(3, o.getId());
			result = st.executeUpdate();
			if (result == 1) {
				System.out.println(result + "�� userDao ���� �Ϸ�");
			} else if (result == 0) {
				System.out.println("userDao ���� ����");
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
				System.out.println(result + "�� userDao ���� �Ϸ�");
			else if (result == 0)
				System.out.println("userDao ���� ����");
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
		} catch (Exception e) {
			System.out.println("userDao ���� ����");
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
		User user;
		try {
			// UserID�� �ش��ϴ� UserItem ����(User_id, item_id, count)
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
		} catch (Exception e) {
			System.out.println("userDao ���� ����");
			throw e;
		} finally {
			close(st);
			close(rs);
		}
		return list;
	}

}
