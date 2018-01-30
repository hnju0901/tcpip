//database를 너무 많이 건드린다.//
//객체지향만 따라가다가 relationship이 있는 database를 건드리기 어렵다.//
//따라서 join을 써서 객체지향과 타협을 함. //
//RDDMS (ORACLE, MYSQL->MARIADB:Open source)이 SQL문을 이용함.//
//open source를 가져와서 조합해서 product만들어서 consulting 해서 돈벌음//
//NO-SQL -> 몽고 DB//instance method이용 할 때는 이용// 
//금융이랑 그런데에서는 sql문 이용//
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
			// UserID에 해당하는 UserItem 정보(User_id, item_id, count)
			st = conn.prepareStatement(Sql.selectUserItem);
			st.setString(1, user.getId());
			rs = st.executeQuery();
			rs.next();

			// item_id를 내가 만든 item에 넣어주는 거야
			int itemId = rs.getInt("itemid");
			item.setId(itemId);
			// item을 user에 넣어준거야
			user.setItem(item);

			// count를 user에 넣어준거야
			int count = rs.getInt("count");
			user.setItemCount(count);
			
		} catch (Exception e) {
			System.out.println("userDao 선택 실패");
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
				System.out.println(result + "건 userItemDao 삭제 완료");
			else if (result == 0)
				System.out.println(result + "건 userItemDao 삭제 실패");
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
				System.out.println(result + "건 userItemDao 입력 완료");
			else if (result == 0)
				System.out.println(result + "건 userItemDao 입력 실패");
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
			st.setString(3, o.getId());
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
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<>();
		User user;
		try {
			// UserID에 해당하는 UserItem 정보(User_id, item_id, count)
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
			System.out.println("userDao 선택 실패");
			throw e;
		} finally {
			close(st);
			close(rs);
		}
		return list;
	}

}
