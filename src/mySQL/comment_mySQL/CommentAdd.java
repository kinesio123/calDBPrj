package mySQL.comment_mySQL;

import java.sql.*;

public class CommentAdd {    
    public CommentAdd() {}
    public static void main(String args[]) {	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");	
    	}catch(ClassNotFoundException e ) {
    		e.printStackTrace();
    	}
    	String url = "jdbc:mysql://localhost:3306/test";
    	String user = "root";
    	String pass = "1234";
	try {		
		Connection con = DriverManager.getConnection(url,user,pass);		
		Statement stmt = con.createStatement();		
		String query = "insert into tb_comment(content, name) " +
                        "values('�ȳ��ϼ���!','ȫ�浿')";
		int i= stmt.executeUpdate(query);			
                System.out.println(i+"���� �߰��Ǿ����ϴ�.");
		stmt.close();
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}    
  }
}