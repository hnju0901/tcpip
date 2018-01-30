package item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Item;


public class ItemDao extends Dao<Item, Integer>{

	@Override
	public void insert(Item o, Connection conn) throws Exception {
		/*PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.insertItem);
			st.setInt(1, o.getId());
			st.setString(2, o.getName());
			st.setInt(3, o.getGrade());
			st.setInt(4, o.getPrice());
			
			result=st.executeUpdate();
			System.out.println(result+"�� �Է�");
		}catch(Exception e){
			System.out.println("�������Է¿���...dao");
		}finally {
			
		close(st);
		}*/
	}

	@Override
	public void delete(Integer i, Connection conn) throws Exception {
	/*	PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.deleteItem);
			st.setInt(1, i);
			result=st.executeUpdate();
			System.out.println(result+"�� ����");
		}catch(Exception e){
			System.out.println("�����ۻ�������...dao");
			throw e;
		}finally {			
		close(st);
		}*/
		
	}

	@Override
	public void update(Item o, Connection conn) throws Exception {
/*		PreparedStatement st = null;
		int result;
		try {
			st = conn.prepareStatement(Sql.updateItem);
			st.setInt(4, o.getId());
			st.setInt(3, o.getPrice());	
			st.setInt(2, o.getGrade());
			st.setString(1, o.getName());
			
			result=st.executeUpdate();
			
			System.out.println(result+"�� ����");
		}catch(Exception e){
			System.out.println("�����ۼ�������...dao");
			throw e;
		}finally {		
		close(st);
		}*/
		
	}

	

	@Override
	public Item select(Integer i, Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		Item item = null;
		try {
			st = conn.prepareStatement(Sql.selectItem);
			st.setInt(1, i);
			rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int grade = rs.getInt("grade");
			int price = rs.getInt("price");
			item = new Item(id, name,grade, price);
		}catch(Exception e) {
			throw e;
		}finally {
			close(rs);
			close(st);
		}	
		return item;

	}

	@Override
	public ArrayList<Item> select(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Item selectItem (int grade, Connection conn) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;
		Item item = null;
		try {
			st = conn.prepareStatement(Sql.gradeItem);
			st.setInt(1, grade);
			rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			
			item = new Item(id, name, grade, price);
		}catch(Exception e) {
			System.out.println(" item �ҷ����� ����");
			throw e;
		}finally {
			close(rs);
			close(st);
		}	
		return item;
	}
}
