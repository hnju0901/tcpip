package com.frame;


public class Sql {
	/////////////////////////////
	public static String insertUser = 
			"INSERT INTO T_USER VALUES (?,?,?,?)";
	//static 변경x, 여러class에서 사용할 수 있도록 하는 것
	public static String updateUser =
			"UPDATE T_USER SET PWD=?, name=?, grade=? WHERE ID = ?";
	public static String deleteUser = 
			"DELETE FROM T_USER WHERE ID=?"; 
	public static String selectUser = 
			"SELECT * FROM T_USER WHERE ID=?"; 
	public static String selectAllUser = 
			"SELECT * FROM T_USER order by id"; 
	
	/////////////////////item
	public static String insertItem = 
			"INSERT INTO T_ITEM VALUES (?,?,?,?)";
	public static String updateItem =
			"UPDATE T_ITEM SET NAME=?, GRADE = ?, PRICE=? WHERE ID = ?";
	public static String deleteItem = 
			"DELETE FROM T_ITEM WHERE ID=?"; 
	
	
	public static String selectItem = 
			"SELECT * FROM T_ITEM WHERE GRADE=?"; 
	public static String selectAllItem = 
			"SELECT * FROM T_ITEM ORDER BY ID"; 
	
	/////////////////////////////////ui
	public static String insertUserItem = 
			"INSERT INTO T_USERITEM VALUES (?,?,?)";
	public static String updateUserItem =
			"UPDATE T_USERITEM SET ITEMID=?, COUNT = ? WHERE USERID = ?";
	public static String deleteUserItem = 
			"DELETE FROM T_USERITEM WHERE USERID=?"; 
	public static String selectUserItem = 
			"SELECT * FROM T_USERITEM WHERE USERID=?"; 
	public static String selectAllUserItem = 
			"SELECT * FROM T_USERITEM ORDER BY USERID"; 
				
}
