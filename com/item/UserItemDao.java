package com.item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.User;

public class UserItemDao extends Dao<User, String> {

	
	public UserItemDao() {
	
	}
	
	@Override
	public void insert(User o, Connection conn) throws Exception {
		PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.insertUserItem);
			st.setString(1, o.getId());
			st.setInt(2, o.getItem().getId());
			st.setInt(3, 1);
			result = st.executeUpdate();
			if(result==1)
				System.out.println(result+"건 userItemDao 입력 완료");
			else if(result==0)
				System.out.println(result+"건 userItemDao 입력 실패");
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
			st = conn.prepareStatement(Sql.updateUserItem);
			st.setString(3, o.getId());
			st.setInt(1, o.getItem().getId());
			st.setInt(2, 1);
			result = st.executeUpdate();
			if(result==1)
			System.out.println(result+"건 userItemDao 수정 완료");
			else if(result==0)
				System.out.println(result+"건 userItemDao 수정 실패");
			
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
				st = conn.prepareStatement(Sql.deleteUserItem);
				st.setString(1, i);
				result = st.executeUpdate();
				if(result==1)
					System.out.println(result+"건 userItemDao 삭제 완료");
				else if(result==0)
					System.out.println(result+"건 userItemDao 삭제 실패");
			} catch (Exception e) {
				throw e;
			} finally {
				close(st);
			}
		}

	@Override
	public User select(String i, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> select(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
