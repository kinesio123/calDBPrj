package mySQL.pstmt;

import java.sql.*;

public class CommentInsert {
	public CommentInsert() {}
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
			Connection con = DriverManager.getConnection(url,user,pass); //Ŀ�ؼ� ȹ��
			PreparedStatement pstmt = null;
			try {
			String query = "insert into (name, contect)" + "values(?,?)";
			pstmt = con.prepareStatement(query); // statement ��ü ���� //��������
				pstmt.setString(1, "ȫ�浿");
				pstmt.setString(2, "�ȳ��ϼ���");
				pstmt.executeQuery();
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
