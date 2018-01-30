package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserBiz {

	// Main Application(TEST) ���� ��û�ϴ� ��� ����
	// Connection �����ϰ� close
	
	UserDao dao;
	
	public UserBiz() {
		//Constructor�� ����̹� �ε�
		//conn�� ������ �� �� ���� ������, ��������� �÷� ���� ����//
		dao= new UserDao();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found...");
		}
	}
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr1";
		String password = "hr1";
		try {
			conn= DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void close(Connection conn) {
		
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
	}
	
	public void register(UserVO user) throws Exception {
		Connection conn = getConnection();
		try{
			dao.insert(user, conn);
			conn.commit();
		}catch(Exception e) {
			conn.rollback();
			throw e;
		}finally {
			close(conn);
		}
	}
	
	public void modify(UserVO user) throws Exception {
		Connection conn = getConnection();
		try{
			dao.update(user, conn);
			conn.commit();
		}catch(Exception e) {
			conn.rollback();
			throw e;
		}finally {
			close(conn);
		}
	}
	
	public void remove(String userId) throws Exception {
		Connection conn = getConnection();
		try{
			dao.delete(userId, conn);
			conn.commit();
		}catch(Exception e) {
			conn.rollback();
			throw e;
		}finally {
			close(conn);
		}
	}
	
	public UserVO get(String userId) throws Exception {
		Connection conn = getConnection();
		UserVO user = dao.select(userId, conn);
		try {
		close(conn);
		}catch(Exception e) {
			throw e;
		}finally {
			close(conn);
		}
		return user;
	}
	
	public ArrayList<UserVO> get() throws Exception {
		Connection conn = getConnection();
		ArrayList<UserVO> list =null;//�տ� ����� list�� �ޱ� ������ null//
		try{
			list= dao.select(conn);
		}catch(Exception e) {
			throw e;
		}finally {
			close(conn);
		}
		return list;
	}
	
	
}
