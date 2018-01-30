package mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

	//UserBiz���� ���Ǵ� CRUD�Լ� ����
	//Connection ������ UserBiz���� �޴´�.
	//SQL���� �ۼ��Ͽ� Oracle�� �ݿ��Ѵ�.
	//����� UserBiz�� �����Ѵ�.
	public UserDao() {
		
	}
	public void insert (UserVO user, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertUser);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			int result = pstmt.executeUpdate();
			//executeQuery();�� update�϶�� ��//
			System.out.println("DAO insert ���: "+ result+"�� �Է� ��");	
		}catch(SQLException e) {
			throw e;
		}finally {
			System.out.println("DAO finally...");
			pstmt.close();
		}
	}
	
	public void update (UserVO user, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateUser);
			pstmt.setString(3, user.getId());
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getName());
			int result = pstmt.executeUpdate();
			System.out.println("DAO update ���: "+ result+"�� ���� ��" );	
		}catch(SQLException e) {
			throw e;
		}finally {
			System.out.println("DAO finally...");
			pstmt.close();
		}
	}

	public void delete (String userId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.delateUser);
			pstmt.setString(1, userId);
			int result = pstmt.executeUpdate();
			
			System.out.println("DAO delate ���: "+ result+"�� ���� ��");	
		}catch(SQLException e) {
			throw e;
		}finally {
			System.out.println("DAO finally...");
			pstmt.close();
		}
	}
	
	public UserVO select (String userId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO user =null;
		try {
			pstmt = conn.prepareStatement(Sql.selectUser);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			rs.next();//jdbc program;
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			user = new UserVO(id, pwd, name);
			
			System.out.println("DAO select ���: "+ userId+ " ���� ��");	
		}catch(SQLException e) {
			throw e;
		}finally {
			System.out.println("DAO finally...");
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}
		return user;
	}
	
	public ArrayList<UserVO> select (Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserVO> list = new ArrayList<>();//data�� ��ƾ��ϱ� ������ null�ƴ�
		try {
			pstmt = conn.prepareStatement(Sql.selectAllUser);
			rs=pstmt.executeQuery();
			UserVO user =null;
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				user = new UserVO(id, pwd, name);
				list.add(user);
			}
			System.out.println("DAO selectAll ���: ��� ���� ��");	
		}catch(SQLException e) {
			throw e;
		}finally {
			System.out.println("DAO finally...");
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}
		return list;
	}
}
