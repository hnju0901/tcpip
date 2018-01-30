package com.frame;


public class Sql {
	///USERITEM
	public static String insertUserItem = "INSERT INTO T_USERITEM VALUES(?,?)";
	
	///USER
	public static String insertUser = "INSERT INTO T_USER VALUES(?,?,?)";
	public static String updateUser = "UPDATE T_USER SET PWD=?, NAME=? WHERE ID=?";
	public static String deleteUser = "DELETE T_USER WHERE ID =?";
	public static String selectUser = "SELECT * FROM T_USER WHERE ID = ?";
	public static String selectAllUser = "SELECT * FROM T_USER";
	//ITEM
	public static String selectItem = "SELECT I.ID AS ID, I.NAME AS NAME, I.PRICE AS PRICE "
			+ " FROM T_USER U, T_ITEM I, T_USERITEM UI"
			+ " WHERE U.ID = UI.USERID"
			+ " AND UI.ITEMID=I.ID"
			+ " AND U.ID=?";
	
	

}
	