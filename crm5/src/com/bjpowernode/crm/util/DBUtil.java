package com.bjpowernode.crm.util;
/**
 * JDBC�����࣬����JDBC����
 * @author DELL
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	//
	private DBUtil() {
		
	}
	
	//����ֻ��Ҫע��һ��
	//��̬������еĳ���������ص�ʱִ�У�ִֻ��һ��
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * ��ȡ���ݿ����Ӷ���
	 * @return
	 * @throws SQLException
	 */
	
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/bjpowernode";
		String user = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	/**
	 * �ر���Դ
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn, Statement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * ��������
	 * @param conn
	 * @throws SQLException
	 */
	public static void beginTransaction(Connection conn) throws SQLException{
		if(conn != null) {
			conn.setAutoCommit(false);   //���Զ��ύ���ƹر�
		}
	}
	
	/**
	 * �ύ����
	 * @param conn
	 * @throws SQLException
	 */
	public static void commitTransaction(Connection conn) throws SQLException{
		if(conn != null) {
			conn.commit(); 
		}
	}
	
	/**
	 * �ع�����
	 * @param conn
	 */
	public static void rollbackTransaction(Connection conn) {
		if(conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
}



























