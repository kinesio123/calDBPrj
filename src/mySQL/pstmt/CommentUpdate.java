package mySQL.pstmt;

import java.sql.*;

public class CommentUpdate {
	public CommentUpdate() {}
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //����̹� �ε�
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pass = "1234";
		
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			PreparedStatement pstmt = null;
			try {
				String query = "Update tb_comment set name='������' ";
				pstmt = con.prepareStatement(query);
				pstmt.executeUpdate();
			} finally {
				if (pstmt != null) {
					pstmt.close();
					if (con != null) {
						con.close();
					}
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
