package calDBPrj_sample;
import java.sql.*;

public class CalEntity {
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //2. ���ؼ� ȹ��
	private String user = "scott"; //2. ���ؼ� ȹ��
	private String pass = "tiger"; //2. ���ؼ� ȹ��
	private Connection con;
	private PreparedStatement stmt;
	
	public CalEntity() { //1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //����̹� �ε�
		}catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	
	public void insert(int op1, String op, int op2, int result) {
		try {		
			con = DriverManager.getConnection(url,user,pass);		
			try {	
				String query = "insert into tb_cal(id, op1, op, op2, result) " +
		                        "values(seq_log.nextval,?,?,?,?)";
				stmt = con.prepareStatement(query);	//3.Statement ��ü ����	 //4.��������	
				stmt.setInt(1, op1);
				stmt.setString(2, op);
				stmt.setInt(3, op2);
				stmt.setInt(4, result);
				
				stmt.executeUpdate(); 
			} finally {
				if (stmt != null) {
					stmt.close(); //6.�ڿ��ݳ�
					if (con != null) {
						con.close(); //6.�ڿ��ݳ�
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} 
	}
}


//try {		
//con = DriverManager.getConnection(url,user,pass);		
//stmt = con.createStatement();	//3.Statement ��ü ����		
//String query = "insert into tb_cal(id, op1, op, op2, result) " +
//                "values(seq_log.nextval, "+ op1 +", '"+ op +"', "+ op2 +", "+ result +")";
//int i= stmt.executeUpdate(query); //������ �ʿ�� ���� ����. /////4.��������			
//System.out.println(i+"���� �߰��Ǿ����ϴ�.");
//stmt.close(); //6.�ڿ��ݳ�
//con.close(); //6.�ڿ��ݳ�
//}catch(SQLException e) {
//e.printStackTrace();
//} 