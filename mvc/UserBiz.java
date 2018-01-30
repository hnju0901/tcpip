package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserBiz {

	// Main Application(TEST) 에서 요청하는 기능 구현
	// Connection 생성하고 close
	
	UserDao dao;
	
	public UserBiz() {
		//Constructor에 드라이버 로딩
		//conn은 공유를 할 수 없기 때문에, 멤버변수로 올려 놓지 않음//
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
		ArrayList<UserVO> list =null;//앞에 날라온 list를 받기 때문에 null//
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
